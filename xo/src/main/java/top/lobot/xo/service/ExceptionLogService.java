package top.lobot.xo.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import top.lobot.xo.entity.ExceptionLog;
import top.lobot.xo.vo.ExceptionLogVO;
import top.lobot.base.service.SuperService;

/**
 *
 * @author ykr
 * @date 2024/8/2
 */
public interface ExceptionLogService extends SuperService<ExceptionLog> {

    /**
     * 获取异常日志列表
     *
     * @param exceptionLogVO
     * @return
     */
    public IPage<ExceptionLog> getPageList(ExceptionLogVO exceptionLogVO);
}
