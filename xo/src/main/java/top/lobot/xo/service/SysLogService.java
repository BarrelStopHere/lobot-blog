package top.lobot.xo.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import top.lobot.xo.entity.SysLog;
import top.lobot.xo.vo.SysLogVO;
import top.lobot.base.service.SuperService;

/**
 *
 * @author ykr
 * @date 2024/8/2
 */
public interface SysLogService extends SuperService<SysLog> {

    /**
     * 获取操作日志列表
     *
     * @param sysLogVO
     * @return
     */
    public IPage<SysLog> getPageList(SysLogVO sysLogVO);
}
