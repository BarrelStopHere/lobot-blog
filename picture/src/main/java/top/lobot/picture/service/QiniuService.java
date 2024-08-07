package top.lobot.picture.service;

import top.lobot.xo.entity.SystemConfig;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 *
 * @author ykr
 * @date 2024/8/7
 */
public interface QiniuService {

    /**
     * 多文件上传
     *
     * @param multipartFileList
     * @return
     * @throws IOException
     */
    List<String> batchUploadFile(List<MultipartFile> multipartFileList) throws IOException;

    /**
     * 文件上传
     *
     * @param multipartFile
     * @return
     * @throws IOException
     */
    String uploadFile(MultipartFile multipartFile) throws IOException;

    /**
     * 通过URL上传图片
     *
     * @param url
     * @param systemConfig
     * @return
     */
    String uploadPictureByUrl(String url, SystemConfig systemConfig);
}
