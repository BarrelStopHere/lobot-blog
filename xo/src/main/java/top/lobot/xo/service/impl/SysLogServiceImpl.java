package top.lobot.xo.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import top.lobot.xo.entity.SysLog;
import top.lobot.utils.DateUtils;
import top.lobot.utils.StringUtils;
import top.lobot.xo.conf.SysConf;
import top.lobot.xo.mapper.admin.SysLogMapper;
import top.lobot.xo.service.SysLogService;
import top.lobot.xo.vo.SysLogVO;
import top.lobot.base.enums.EStatus;
import top.lobot.base.conf.Constants;
import top.lobot.base.mybatis.query.LambdaQueryWrapperPlus;
import top.lobot.base.service.impl.SuperServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 *
 * @author ykr
 * @date 2024/8/2
 */
@Service
public class SysLogServiceImpl extends SuperServiceImpl<SysLogMapper, SysLog> implements SysLogService {

    @Autowired
    SysLogService sysLogService;

    @Override
    public IPage<SysLog> getPageList(SysLogVO sysLogVO) {

        LambdaQueryWrapperPlus<SysLog> queryWrapper = new LambdaQueryWrapperPlus<>();
        queryWrapper.eq(SysLog::getUserName, sysLogVO.getUserName().trim());
        queryWrapper.eq(SysLog::getOperation, sysLogVO.getOperation());
        queryWrapper.eq(SysLog::getIp, sysLogVO.getIp());


        if (StringUtils.isNotBlank(sysLogVO.getStartTime())) {
            String[] time = sysLogVO.getStartTime().split(SysConf.FILE_SEGMENTATION);
            if (time.length == Constants.NUM_TWO) {
                queryWrapper.between(SysLog::getCreateTime, DateUtils.str2Date(time[0]), DateUtils.str2Date(time[1]));
            }
        }

        if (StringUtils.isNotBlank(sysLogVO.getSpendTimeStr())) {
            String[] spendTimeList = StringUtils.split(sysLogVO.getSpendTimeStr(), Constants.SYMBOL_UNDERLINE);
            if (spendTimeList.length == Constants.NUM_TWO) {
                queryWrapper.between(SysLog::getSpendTime, Integer.valueOf(spendTimeList[0]), Integer.valueOf(spendTimeList[1]));
            }
        }

        Page<SysLog> page = new Page<>();
        page.setCurrent(sysLogVO.getCurrentPage());
        page.setSize(sysLogVO.getPageSize());
        queryWrapper.eq(SysLog::getStatus, EStatus.ENABLE);
        queryWrapper.orderByDesc(SysLog::getCreateTime);
        IPage<SysLog> pageList = sysLogService.page(page, queryWrapper);
        return pageList;
    }
}
