package top.lobot.xo.utils;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import top.lobot.base.conf.ErrorCode;
import top.lobot.base.enums.EFilePriority;
import top.lobot.base.enums.EStatus;
import top.lobot.base.exception.exceptionType.QueryException;
import top.lobot.utils.RedisUtil;
import top.lobot.xo.conf.MessageConf;
import top.lobot.xo.conf.RedisConf;
import top.lobot.xo.conf.SQLConf;
import top.lobot.xo.conf.SysConf;
import top.lobot.xo.entity.SystemConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import top.lobot.xo.service.SystemConfigService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author ykr
 * @date 2024/8/2
 */
@Slf4j
@Component
public class WebUtil {

    @Autowired
    private SystemConfigService systemConfigService;

    @Autowired
    private RedisUtil redisUtil;

    /**
     * 格式化数据获取图片列表
     *
     * @param result
     * @return
     */
    public List<String> getPicture(String result) {
        String picturePriority = "";
        String localPictureBaseUrl = "";
        String qiNiuPictureBaseUrl = "";
        String minioPictureBaseUrl = "";
        // 从Redis中获取系统配置
        String systemConfigJson = redisUtil.get(RedisConf.SYSTEM_CONFIG);
        if (StringUtils.isEmpty(systemConfigJson)) {
            QueryWrapper<SystemConfig> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq(SQLConf.STATUS, EStatus.ENABLE);
            SystemConfig systemConfig = systemConfigService.getOne(queryWrapper);
            if (systemConfig == null) {
                throw new QueryException(MessageConf.SYSTEM_CONFIG_IS_NOT_EXIST);
            } else {
                // 将系统配置存入Redis中【设置过期时间24小时】
                redisUtil.setEx(RedisConf.SYSTEM_CONFIG, JSONObject.toJSONString(systemConfig), 24, TimeUnit.HOURS);
            }
            picturePriority = systemConfig.getPicturePriority();
            localPictureBaseUrl = systemConfig.getLocalPictureBaseUrl();
            qiNiuPictureBaseUrl = systemConfig.getQiNiuPictureBaseUrl();
            minioPictureBaseUrl = systemConfig.getMinioPictureBaseUrl();
        } else {
            SystemConfig systemConfig = JSONObject.parseObject(systemConfigJson, SystemConfig.class);
            if (systemConfig == null) {
                throw new QueryException(ErrorCode.QUERY_DEFAULT_ERROR, "系统配置转换错误，请检查系统配置，或者清空Redis后重试！");
            }
            picturePriority = systemConfig.getPicturePriority();
            localPictureBaseUrl = systemConfig.getLocalPictureBaseUrl();
            qiNiuPictureBaseUrl = systemConfig.getQiNiuPictureBaseUrl();
            minioPictureBaseUrl = systemConfig.getMinioPictureBaseUrl();
        }

        List<String> picUrls = new ArrayList<>();
        try {
            Map<String, Object> picMap = (Map<String, Object>) JSONObject.parseObject(result, Map.class);
            if (SysConf.SUCCESS.equals(picMap.get(SysConf.CODE))) {
                List<Map<String, Object>> picData = (List<Map<String, Object>>) picMap.get(SysConf.DATA);
                if (picData.size() > 0) {
                    for (int i = 0; i < picData.size(); i++) {
                        // 判断文件显示优先级【需要显示存储在哪里的图片】
                        if (EFilePriority.QI_NIU.equals(picturePriority)) {
                            picUrls.add(qiNiuPictureBaseUrl + picData.get(i).get(SysConf.QI_NIU_URL));
                        } else if (EFilePriority.MINIO.equals(picturePriority)) {
                            picUrls.add(minioPictureBaseUrl + picData.get(i).get(SysConf.MINIO_URL));
                        } else {
                            picUrls.add(localPictureBaseUrl + picData.get(i).get(SysConf.URL));
                        }
                    }
                }
            }
        } catch (Exception e) {
            log.error("从Json中获取图片列表失败");
            log.error(e.getMessage());
            return picUrls;
        }
        return picUrls;
    }

    /**
     * 获取图片，返回Map
     *
     * @param result
     * @return
     */
    public List<Map<String, Object>> getPictureMap(String result) {

        String picturePriority = "";
        String localPictureBaseUrl = "";
        String qiNiuPictureBaseUrl = "";
        String minioPictureBaseUrl = "";
        // 从Redis中获取系统配置
        String systemConfigJson = redisUtil.get(RedisConf.SYSTEM_CONFIG);
        if (StringUtils.isEmpty(systemConfigJson)) {
            QueryWrapper<SystemConfig> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq(SQLConf.STATUS, EStatus.ENABLE);
            SystemConfig systemConfig = systemConfigService.getOne(queryWrapper);
            if (systemConfig == null) {
                throw new QueryException(MessageConf.SYSTEM_CONFIG_IS_NOT_EXIST);
            } else {
                // 将系统配置存入Redis中【设置过期时间24小时】
                redisUtil.setEx(RedisConf.SYSTEM_CONFIG, JSONObject.toJSONString(systemConfig), 24, TimeUnit.HOURS);
            }
            picturePriority = systemConfig.getPicturePriority();
            localPictureBaseUrl = systemConfig.getLocalPictureBaseUrl();
            qiNiuPictureBaseUrl = systemConfig.getQiNiuPictureBaseUrl();
            minioPictureBaseUrl = systemConfig.getMinioPictureBaseUrl();
        } else {
            SystemConfig systemConfig = JSONObject.parseObject(systemConfigJson, SystemConfig.class);
            picturePriority = systemConfig.getPicturePriority();
            localPictureBaseUrl = systemConfig.getLocalPictureBaseUrl();
            qiNiuPictureBaseUrl = systemConfig.getQiNiuPictureBaseUrl();
            minioPictureBaseUrl = systemConfig.getMinioPictureBaseUrl();
        }

        List<Map<String, Object>> resultList = new ArrayList<>();
        Map<String, Object> picMap = JSONObject.parseObject(result, JSONObject.class);
        if (SysConf.SUCCESS.equals(picMap.get(SysConf.CODE))) {
            List<Map<String, Object>> picData = (List<Map<String, Object>>) picMap.get(SysConf.DATA);
            if (picData.size() > 0) {
                for (Map<String, Object> picDatum : picData) {
                    Map<String, Object> map = new HashMap<>();
                    if (StringUtils.isEmpty(picDatum.get(SysConf.UID))) {
                        continue;
                    }
                    // 判断文件显示优先级【需要显示存储在哪里的图片】
                    if (EFilePriority.QI_NIU.equals(picturePriority)) {
                        map.put(SysConf.URL, qiNiuPictureBaseUrl + picDatum.get(SysConf.QI_NIU_URL));
                    } else if (EFilePriority.MINIO.equals(picturePriority)) {
                        map.put(SysConf.URL, minioPictureBaseUrl + picDatum.get(SysConf.MINIO_URL));
                    } else {
                        map.put(SysConf.URL, localPictureBaseUrl + picDatum.get(SysConf.URL));
                    }

                    map.put(SysConf.UID, picDatum.get(SysConf.UID));
                    resultList.add(map);
                }
            }
        } else if (SysConf.ERROR.equals(picMap.get(SysConf.CODE))) {
            log.error("获取图片失败，图片服务出现异常：{}", picMap.get(SysConf.MESSAGE));
        } else {
            log.error("获取图片失败");
        }
        return resultList;
    }

    /**
     * 获取结果集的数据
     *
     * @param result
     * @return
     */
    public <T> T getData(String result, Class<T> beanType) {
        if (StringUtils.isEmpty(result)) {
            return null;
        }
        JSONObject dataMap = JSONObject.parseObject(result, JSONObject.class);
        if (SysConf.SUCCESS.equals(dataMap.get(SysConf.CODE))) {
            return beanType.cast(dataMap.get(SysConf.DATA));
        }
        return null;
    }

    /**
     * 获取结果集的消息
     *
     * @param result
     * @return
     */
    public Map<String, String> getMessage(String result) {
        Map<String, String> ret = new HashMap<>();
        if (StringUtils.isEmpty(result)) {
            ret.put(SysConf.CODE, SysConf.ERROR);
            ret.put(SysConf.MESSAGE, MessageConf.PARAM_INCORRECT);
            return ret;
        }
        Map<String, Object> dataMap = JSONObject.parseObject(result, JSONObject.class);
        if (SysConf.SUCCESS.equals(dataMap.get(SysConf.CODE)) && dataMap.get(SysConf.MESSAGE) != null) {
            ret.put(SysConf.CODE, SysConf.SUCCESS);
            ret.put(SysConf.MESSAGE, dataMap.get(SysConf.MESSAGE).toString());
            return ret;
        } else {
            ret.put(SysConf.CODE, SysConf.ERROR);
            ret.put(SysConf.MESSAGE, dataMap.get(SysConf.MESSAGE).toString());
            return ret;
        }
    }


    /**
     * 获取结果集的内容 【带有分页信息】
     *
     * @param result
     * @return
     */
    public <T> List<T> getListByPage(String result, Class<T> beanType) {
        if (StringUtils.isEmpty(result)) {
            return null;
        }
        Map<String, Object> dataMap = JSONObject.parseObject(result, JSONObject.class);
        List<T> resultList = new ArrayList<>();
        if (SysConf.SUCCESS.equals(dataMap.get(SysConf.CODE))) {
            Map<String, Object> data = (Map<String, Object>) dataMap.get(SysConf.DATA);
            List<Map<String, Object>> list = (List<Map<String, Object>>) data.get(SysConf.RECORDS);
            list.forEach(item -> {
                resultList.add(beanType.cast(item));
            });
            return resultList;
        } else {
            log.error((String) dataMap.get(SysConf.MESSAGE));
            return resultList;
        }
    }

    /**
     * 获取结果集的内容
     *
     * @param result
     * @return
     */
    public <T> List<T> getList(String result, Class<T> beanType) {
        Map<String, Object> dataMap = JSONObject.parseObject(result, JSONObject.class);
        List<T> resultList = new ArrayList<>();
        if (SysConf.SUCCESS.equals(dataMap.get(SysConf.CODE))) {
            List<Map<String, Object>> data = (List<Map<String, Object>>) dataMap.get(SysConf.DATA);
            data.forEach(item -> {
                resultList.add(beanType.cast(item));
            });
            return resultList;
        } else {
            log.error((String) dataMap.get(SysConf.MESSAGE));
            return resultList;
        }
    }
}