package top.lobot.base.exception;

import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.util.CollectionUtils;
import top.lobot.base.conf.Constants;
import top.lobot.base.enums.ELanguage;
import top.lobot.utils.StringUtils;

import java.nio.charset.Charset;
import java.util.*;

/**
 * 异常提示
 *
 * @author ykr
 * @date 2024/8/1
 */
public class ErrorMessageUtil {

    /**
     * 根据错误提示码，获取对应错误提示信息（中文）
     *
     * @param errorCode
     * @return
     */
    public static String getErrorMessage(String errorCode) {
        return ErrorMessage.getErrorMessage(errorCode, ELanguage.ZH.getCode());
    }

    /**
     * 根据错误提示码、语言获取对应错误提示信息
     * 注意：language 传入空时，按照中文处理
     *
     * @param errorCode
     * @param language
     * @return
     */
    public static String getErrorMessage(String errorCode, String language) {
        return ErrorMessage.getErrorMessage(errorCode, language);
    }

    /**
     * 内部类，用于初始化错误提示信息
     */
    private static final class ErrorMessage {

        private static final Map<String, Map<String, String>> ERROR_MESSAGE_MAP = new HashMap<>();

        static {
            try {

                // 初始化需要使用的编码
                Charset ISO_8859_1 = Charset.forName("ISO-8859-1");
                Charset UTF_8 = Charset.forName("UTF-8");

                // 循环系统支持语言
                for (ELanguage lang : ELanguage.values()) {

                    // 获取对应语言的资源文件路径
                    List<String> resourcePathList = getResourcesPath(lang.getCode());

                    // 初始化当前语言对应的提示信息容器
                    Map<String, String> errorMessageMap = new HashMap<>();

                    // 遍历循环资源文件，读取错误提示信息
                    for (String resourcePath : resourcePathList) {
                        Properties properties = PropertiesLoaderUtils.loadAllProperties(resourcePath);
                        properties.forEach((key, value) -> {
                            errorMessageMap.put(new String(((String) key).getBytes(ISO_8859_1), UTF_8), new String(((String) value).getBytes(ISO_8859_1), UTF_8));
                        });
                    }

                    // 缓存当前语言对应的错误提示信息
                    ERROR_MESSAGE_MAP.put(lang.getCode(), errorMessageMap);
                }
            } catch (Exception e) {
            }
        }

        /**
         * 获取内部错误提示信息
         *
         * @param errorCode
         * @param language
         * @return
         */
        private static final String getErrorMessage(String errorCode, String language) {
            language = StringUtils.isBlank(language) ? ELanguage.ZH.getCode() : language;
            Map<String, String> errorMessageMap = ERROR_MESSAGE_MAP.get(language);
            return CollectionUtils.isEmpty(errorMessageMap) ? null : errorMessageMap.get(errorCode);
        }

        /**
         * 根据规则获取错误提示资源文件路径
         * 注意：目前没有做外置化配置，亦不支持用户自定义；后续有需要则提供代码配置接口
         *
         * @return
         */
        private static final List<String> getResourcesPath(String lang) {

            String[] parentPathArr = new String[]{"resource"};
            String[] fileNameArr = new String[]{"error-message"};
            String[] fileNameSuffixArr = new String[]{".properties"};

            List<String> resourcePath = new ArrayList<>();
            for (String path : parentPathArr) {
                for (String fileName : fileNameArr) {
                    for (String suffix : fileNameSuffixArr) {
                        resourcePath.add(path + Constants.PATH_SEPARATOR + fileName + "-" + lang + suffix);
                    }
                }
            }
            return resourcePath;
        }
    }
}
