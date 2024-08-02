package top.lobot.xo.service;

import top.lobot.xo.entity.SystemConfig;
import top.lobot.base.service.SuperService;
import top.lobot.xo.vo.SystemConfigVO;

import java.util.List;

/**
 *
 * @author ykr
 * @date 2024/8/2
 */
public interface SystemConfigService extends SuperService<SystemConfig> {

    /**
     * 获取系统配置
     *
     * @return
     */
    SystemConfig getConfig();

    /**
     * 通过Key前缀清空Redis缓存
     *
     * @param key
     * @return
     */
    String cleanRedisByKey(List<String> key);

    /**
     * 修改系统配置
     *
     * @param systemConfigVO
     * @return
     */
    String editSystemConfig(SystemConfigVO systemConfigVO);

    /**
     * 获取系统配置中的搜索模式
     * @return
     */
    String getSearchModel();

}
