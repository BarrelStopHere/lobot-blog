package top.lobot.xo.entity.user;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;
import top.lobot.base.entity.BaseEntity;
import top.lobot.xo.entity.admin.Role;

import java.util.Date;
import java.util.List;

/**
 * 用户
 *
 * @author ykr
 * @date 2024/7/31
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("user")
public class User extends BaseEntity<User> {
    private static final long serialVersionUID = 7850722315180876426L;
    private Integer id;
    private String name;
    private String nickName;
    private String mobile;
    private String email;
    private Integer roleId;
    private String password;
    private String status;
    private String sex;
    private String avatar;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date birthday;
    private String qq;
    private String wechat;
    private String gitee;
    private String github;
    /** 职业 */
    private String occupation;
    private String description;
    /** 简历(md) */
    private String personResume;
    private Integer loginTimes;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date lastLoginTime;
    /** 上次登录ip */
    private String lastLoginIp;

    // 以下字段不存入数据库

    /**
     * 用户头像
     */
    @TableField(exist = false)
    private List<String> photoList;

    /**
     * 所拥有的角色名
     */
    @TableField(exist = false)
    private List<String> roleNames;

    /**
     * 所拥有的角色名
     */
    @TableField(exist = false)
    private Role role;

    /**
     * 验证码
     */
    @TableField(exist = false)
    private String validCode;

    /**
     * 已用网盘容量
     */
    @TableField(exist = false)
    private Long storageSize;

    /**
     * 最大网盘容量
     */
    @TableField(exist = false)
    private Long maxStorageSize;

    /**
     * 令牌UID【主要用于换取token令牌，防止token直接暴露到在线用户管理中】
     */
    @TableField(exist = false)
    private String tokenUid;
}
