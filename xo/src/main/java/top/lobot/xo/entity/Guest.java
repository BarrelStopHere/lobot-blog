package top.lobot.xo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.EqualsAndHashCode;
import top.lobot.base.entity.BaseEntity;
import lombok.Data;

import java.util.Date;

/**
 *
 * @author ykr
 * @date 2024/8/2
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("guest")
public class Guest extends BaseEntity<Guest> {

    private static final long serialVersionUID = 43066594284460227L;

    /**
     * 用户名
     */
    private String name;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 登录次数
     */
    private Integer loginTimes;

    /**
     * 最后登录时间
     */
    private Date lastLoginTime;

    /**
     * 最后登录IP
     */
    private String lastLoginIp;
}
