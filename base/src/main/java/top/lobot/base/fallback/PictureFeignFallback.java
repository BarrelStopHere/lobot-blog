package top.lobot.base.fallback;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import top.lobot.base.feign.PictureFeignClient;
import top.lobot.base.holder.RequestHolder;
import top.lobot.base.vo.FileVO;
import top.lobot.utils.ResultUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 图片服务降级兜底方法【当服务不可用时会触发】
 *
 * @author ykr
 * @date 2024/8/2
 */
@Component
@Slf4j
public class PictureFeignFallback implements PictureFeignClient {

    @Override
    public String getPicture(String fileIds, String code) {
        HttpServletRequest request = RequestHolder.getRequest();
        StringBuffer requestURL = request.getRequestURL();
        log.error("图片服务出现异常，服务降级返回，请求路径: {}", requestURL);
        return ResultUtil.errorWithMessage("获取图片服务降级返回");
    }

    @Override
    public String uploadPicsByUrl(FileVO fileVO) {
        HttpServletRequest request = RequestHolder.getRequest();
        StringBuffer requestURL = request.getRequestURL();
        log.error("图片服务出现异常，更新图片失败，服务降级返回，请求路径: {}", requestURL);
        return ResultUtil.errorWithMessage("更新图片服务降级返回");
    }

    @Override
    public String initStorageSize(String adminUid, Long maxStorageSize) {
        HttpServletRequest request = RequestHolder.getRequest();
        StringBuffer requestURL = request.getRequestURL();
        log.error("图片服务出现异常，初始化网盘容量失败，服务降级返回，请求路径: {}", requestURL);
        return ResultUtil.errorWithMessage("图片服务出现异常，初始化网盘容量失败");
    }

    @Override
    public String editStorageSize(String adminUid, Long maxStorageSize) {
        HttpServletRequest request = RequestHolder.getRequest();
        StringBuffer requestURL = request.getRequestURL();
        log.error("图片服务出现异常，更新网盘容量失败，服务降级返回，请求路径: {}", requestURL);
        return ResultUtil.errorWithMessage("图片服务出现异常，更新网盘容量失败，服务降级返回");
    }

    @Override
    public String getStorageByAdminUid(List<String> adminUidList) {
        HttpServletRequest request = RequestHolder.getRequest();
        StringBuffer requestURL = request.getRequestURL();
        log.error("图片服务出现异常，获取网盘容量失败，服务降级返回，请求路径: {}", requestURL);
        return ResultUtil.errorWithMessage("图片服务出现异常，获取网盘容量失败，服务降级返回");
    }
}
