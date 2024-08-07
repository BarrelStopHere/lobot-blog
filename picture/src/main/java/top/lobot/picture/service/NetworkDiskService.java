package top.lobot.picture.service;

import top.lobot.xo.entity.NetworkDisk;
import top.lobot.picture.vo.NetworkDiskVO;
import top.lobot.base.service.SuperService;

import java.util.List;
import java.util.Map;

/**
 *
 * @author ykr
 * @date 2024/8/7
 */
public interface NetworkDiskService extends SuperService<NetworkDisk> {

    /**
     * 插入文件
     *
     * @param networkDisk
     */
    void insertFile(NetworkDisk networkDisk);

    /**
     * 批量插入文件
     *
     * @param networkDiskList
     */
    void batchInsertFile(List<NetworkDisk> networkDiskList);

    /**
     * 更新文件
     *
     * @param networkDisk
     */
    void updateFile(NetworkDisk networkDisk);

    /**
     * 通过ID查询文件
     *
     * @param networkDisk
     * @return
     */
    NetworkDisk selectFileById(NetworkDisk networkDisk);

    /**
     * 查询目录结构树
     *
     * @return
     */
    List<NetworkDisk> selectFilePathTree();

    /**
     * 查询文件列表
     *
     * @param networkDisk
     * @return
     */
    List<NetworkDisk> selectFileList(NetworkDisk networkDisk);

    /**
     * 通过ID查询文件列表
     *
     * @param uidList
     * @return
     */
    List<NetworkDisk> selectFileListByIds(List<Integer> uidList);

    /**
     * 通过文件路径查询文件列表
     *
     * @param filePath
     * @return
     */
    List<NetworkDisk> selectFileTreeListLikeFilePath(String filePath);

    /**
     * 删除文件
     *
     * @param networkDiskVO
     */
    void deleteFile(NetworkDiskVO networkDiskVO, Map<String, String> qiNiuConfig);

    /**
     * 通过文件ID删除文件
     *
     * @param fileIdList
     */
    void deleteFileByIds(List<Integer> fileIdList);

    /**
     * 通过路径更新文件
     *
     * @param networkDiskVO
     */
    void updateFilepathByFilepath(NetworkDiskVO networkDiskVO);

    /**
     * 通过拓展名查询文件
     *
     * @param filenameList
     * @param adminUid
     * @return
     */
    List<NetworkDisk> selectFileByExtendName(List<String> filenameList, String adminUid);
}
