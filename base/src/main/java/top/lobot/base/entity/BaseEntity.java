package top.lobot.base.entity;


import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;
import top.lobot.base.enums.EStatus;

import java.util.Date;

/**
 * 封装基础实体类的常用字段
 *
 * @author ykr
 * @date 2024/7/31
 */
@EqualsAndHashCode(callSuper = true)
@Data
@SuppressWarnings("rawtypes")
public class BaseEntity <T extends Model> extends Model{
    private static final long serialVersionUID = 5685131228097641783L;
    /**
     * 唯一UID
     */
    @TableId(value = "uid", type = IdType.UUID)
    private String uid;

    /**
     * 状态 0：失效  1：生效
     */
    private int status;

    /**
     * @TableField 配置需要填充的字段
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date createTime;

    /**
     * 更新时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    public BaseEntity() {
        this.status = EStatus.ENABLE;
        this.createTime = new Date();
        this.updateTime = new Date();
    }
}
