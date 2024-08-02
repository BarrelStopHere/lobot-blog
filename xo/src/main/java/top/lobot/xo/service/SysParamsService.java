package top.lobot.xo.service;

import top.lobot.xo.entity.SysParams;
import top.lobot.xo.vo.SysParamsVO;
import top.lobot.base.service.SuperService;

import java.util.List;

/**
 *
 * @author ykr
 * @date 2024/8/2
 */
public interface SysParamsService extends SuperService<SysParams> {

    /**
     * 通过 参数键名 获取参数配置
     *
     * @param paramsKey
     * @return
     */
    public SysParams getSysParamsByKey(String paramsKey);

    /**
     * 通过 参数键名 获取参数值
     *
     * @param paramsKey
     * @return
     */
    public String getSysParamsValueByKey(String paramsKey);

    /**
     * 新增参数配置
     *
     * @param sysParamsVO
     */
    public String addSysParams(SysParamsVO sysParamsVO);

    /**
     * 编辑参数配置
     *
     * @param sysParamsVO
     */
    public String editSysParams(SysParamsVO sysParamsVO);

    /**
     * 批量删除参数配置
     *
     * @param sysParamsVOList
     */
    public String deleteBatchSysParams(List<SysParamsVO> sysParamsVOList);
}
