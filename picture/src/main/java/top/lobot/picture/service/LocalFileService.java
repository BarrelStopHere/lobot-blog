package top.lobot.picture.service;

import top.lobot.xo.entity.FileSort;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 *
 * @author ykr
 * @date 2024/8/7
 */
public interface LocalFileService {

    /**
     * 多文件上传
     *
     * @param multipartFileList
     * @param fileSort
     * @return
     * @throws IOException
     */
    List<String> batchUploadFile(List<MultipartFile> multipartFileList, FileSort fileSort) throws IOException;

    /**
     * 文件上传
     *
     * @param multipartFile
     * @param fileSort
     * @return
     * @throws IOException
     */
    String uploadFile(MultipartFile multipartFile, FileSort fileSort) throws IOException;

    /**
     * 通过URL上传图片
     *
     * @param url
     * @param fileSort
     * @return
     */
    String uploadPictureByUrl(String url, FileSort fileSort);
}
