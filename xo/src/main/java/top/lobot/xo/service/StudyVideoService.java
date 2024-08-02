package top.lobot.xo.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import top.lobot.xo.entity.StudyVideo;
import top.lobot.xo.vo.StudyVideoVO;
import top.lobot.base.service.SuperService;

import java.util.List;

/**
 *
 * @author ykr
 * @date 2024/8/2
 */
public interface StudyVideoService extends SuperService<StudyVideo> {
    /**
     * 获取学习视频列表
     *
     * @param studyVideoVO
     * @return
     */
    public IPage<StudyVideo> getPageList(StudyVideoVO studyVideoVO);

    /**
     * 新增学习视频
     *
     * @param studyVideoVO
     */
    public String addStudyVideo(StudyVideoVO studyVideoVO);

    /**
     * 编辑学习视频
     *
     * @param studyVideoVO
     */
    public String editStudyVideo(StudyVideoVO studyVideoVO);

    /**
     * 批量删除学习视频
     *
     * @param studyVideoVOList
     */
    public String deleteBatchStudyVideo(List<StudyVideoVO> studyVideoVOList);
}
