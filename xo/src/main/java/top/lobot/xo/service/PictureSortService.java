package top.lobot.xo.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import top.lobot.xo.entity.PictureSort;
import top.lobot.xo.vo.PictureSortVO;
import top.lobot.base.service.SuperService;

/**
 *
 * @author ykr
 * @date 2024/8/2
 */
public interface PictureSortService extends SuperService<PictureSort> {

    /**
     * 获取图片分类列表
     *
     * @param pictureSortVO
     * @return
     */
    public IPage<PictureSort> getPageList(PictureSortVO pictureSortVO);

    /**
     * 新增图片分类
     *
     * @param pictureSortVO
     */
    public String addPictureSort(PictureSortVO pictureSortVO);

    /**
     * 编辑图片分类
     *
     * @param pictureSortVO
     */
    public String editPictureSort(PictureSortVO pictureSortVO);

    /**
     * 删除图片分类
     *
     * @param pictureSortVO
     */
    public String deletePictureSort(PictureSortVO pictureSortVO);

    /**
     * 置顶图片分类
     *
     * @param pictureSortVO
     */
    public String stickPictureSort(PictureSortVO pictureSortVO);
}
