package top.lobot.spider.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import top.lobot.spider.global.SysConf;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Slf4j
public class MetaObjectHandlerConfig implements MetaObjectHandler {


    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("插入方法填充");
        setFieldValByName(SysConf.CREATE_TIME, new Date(), metaObject);
        setFieldValByName(SysConf.UPDATE_TIME, new Date(), metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("更新方法填充");
        setFieldValByName(SysConf.UPDATE_TIME, new Date(), metaObject);
    }
}
