package top.lobot.xo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import top.lobot.xo.entity.SysParams;
import top.lobot.utils.RedisUtil;
import top.lobot.utils.ResultUtil;
import top.lobot.utils.StringUtils;
import top.lobot.xo.conf.MessageConf;
import top.lobot.xo.conf.RedisConf;
import top.lobot.xo.conf.SQLConf;
import top.lobot.xo.conf.SysConf;
import top.lobot.xo.mapper.SysParamsMapper;
import top.lobot.xo.service.SysParamsService;
import top.lobot.xo.vo.SysParamsVO;
import top.lobot.base.enums.EStatus;
import top.lobot.base.exception.exceptionType.QueryException;
import top.lobot.base.conf.Constants;
import top.lobot.base.enums.ErrorCode;
import top.lobot.base.service.impl.SuperServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;


/**
 *
 * @author ykr
 * @date 2024/8/2
 */
@Service
public class SysParamsServiceImpl extends SuperServiceImpl<SysParamsMapper, SysParams> implements SysParamsService {

    @Autowired
    SysParamsService sysParamsService;

    @Autowired
    RedisUtil redisUtil;

    @Override
    public SysParams getSysParamsByKey(String paramsKey) {
        QueryWrapper<SysParams> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(SQLConf.PARAMS_KEY, paramsKey);
        queryWrapper.eq(SQLConf.STATUS, EStatus.ENABLE);
        queryWrapper.last(SysConf.LIMIT_ONE);
        SysParams sysParams = sysParamsService.getOne(queryWrapper);
        return sysParams;
    }

    @Override
    public String getSysParamsValueByKey(String paramsKey) {
        // 判断Redis中是否包含该key的数据
        String redisKey = RedisConf.SYSTEM_PARAMS + RedisConf.SEGMENTATION + paramsKey;
        String paramsValue = redisUtil.get(redisKey);
        // 如果Redis中不存在，那么从数据库中获取
        if (StringUtils.isEmpty(paramsValue)) {
            SysParams sysParams = sysParamsService.getSysParamsByKey(paramsKey);
            // 如果数据库也不存在，将抛出异常【需要到找到 doc/数据库脚本 更新数据库中的 sys_params表】
            if (sysParams == null || StringUtils.isEmpty(sysParams.getParamsValue())) {
                throw new QueryException(ErrorCode.PLEASE_CONFIGURE_SYSTEM_PARAMS, MessageConf.PLEASE_CONFIGURE_SYSTEM_PARAMS);
            }
            paramsValue = sysParams.getParamsValue();
            redisUtil.set(redisKey, paramsValue);
        }
        return paramsValue;
    }

    @Override
    public String addSysParams(SysParamsVO sysParamsVO) {
        // 判断添加的字典类型是否存在
        QueryWrapper<SysParams> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(SQLConf.PARAMS_KEY, sysParamsVO.getParamsKey());
        queryWrapper.eq(SQLConf.STATUS, EStatus.ENABLE);
        queryWrapper.last(SysConf.LIMIT_ONE);
        SysParams temp = sysParamsService.getOne(queryWrapper);
        if (temp != null) {
            return ResultUtil.errorWithMessage(MessageConf.ENTITY_EXIST);
        }
        SysParams sysParams = new SysParams();
        sysParams.setParamsName(sysParamsVO.getParamsName());
        sysParams.setParamsKey(sysParamsVO.getParamsKey());
        sysParams.setParamsValue(sysParamsVO.getParamsValue());
        sysParams.setParamsType(sysParamsVO.getParamsType());
        sysParams.setRemark(sysParamsVO.getRemark());
        sysParams.setSort(sysParamsVO.getSort());
        sysParams.insert();
        return ResultUtil.successWithMessage(MessageConf.INSERT_SUCCESS);
    }

    @Override
    public String editSysParams(SysParamsVO sysParamsVO) {
        SysParams sysParams = sysParamsService.getById(sysParamsVO.getUid());
        // 判断编辑的参数键名是否存在
        if (!sysParamsVO.getParamsKey().equals(sysParams.getParamsKey())) {
            QueryWrapper<SysParams> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq(SQLConf.PARAMS_KEY, sysParamsVO.getParamsKey());
            queryWrapper.eq(SQLConf.STATUS, EStatus.ENABLE);
            queryWrapper.last(SysConf.LIMIT_ONE);
            SysParams temp = sysParamsService.getOne(queryWrapper);
            if (temp != null) {
                return ResultUtil.errorWithMessage(MessageConf.ENTITY_EXIST);
            }
        }
        sysParams.setParamsName(sysParamsVO.getParamsName());
        sysParams.setParamsKey(sysParamsVO.getParamsKey());
        sysParams.setParamsValue(sysParamsVO.getParamsValue());
        sysParams.setParamsType(sysParamsVO.getParamsType());
        sysParams.setRemark(sysParamsVO.getRemark());
        sysParams.setSort(sysParamsVO.getSort());
        sysParams.setUpdateTime(new Date());
        sysParams.updateById();
        // 清空Redis中存在的配置
        redisUtil.delete(RedisConf.SYSTEM_PARAMS + RedisConf.SEGMENTATION + sysParamsVO.getParamsKey());
        return ResultUtil.successWithMessage(MessageConf.UPDATE_SUCCESS);
    }

    @Override
    public String deleteBatchSysParams(List<SysParamsVO> sysParamsVOList) {
        List<String> sysParamsUidList = new ArrayList<>();
        sysParamsVOList.forEach(item -> {
            sysParamsUidList.add(item.getUid());
        });
        if (sysParamsUidList.size() >= 0) {
            Collection<SysParams> sysParamsList = sysParamsService.listByIds(sysParamsUidList);
            // 更新完成数据库后，还需要清空Redis中的缓存，因此需要存储键值
            List<String> redisKeys = new ArrayList<>();
            for(SysParams item : sysParamsList) {
                // 判断删除列表中是否含有系统内置参数
                if(item.getParamsType() == Constants.NUM_ONE) {
                    return ResultUtil.errorWithMessage("系统内置参数无法删除");
                }
                item.setStatus(EStatus.DISABLED);
                redisKeys.add(RedisConf.SYSTEM_PARAMS + RedisConf.SEGMENTATION + item.getParamsKey());
            }
            sysParamsService.updateBatchById(sysParamsList);
            // 清空Redis中的配置
            redisUtil.delete(redisKeys);
            return ResultUtil.successWithMessage(MessageConf.DELETE_SUCCESS);
        } else {
            return ResultUtil.errorWithMessage(MessageConf.DELETE_FAIL);
        }
    }
}
