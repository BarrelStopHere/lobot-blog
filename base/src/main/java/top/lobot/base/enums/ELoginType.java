package top.lobot.base.enums;

/**
 * 登录方式
 *
 * @author ykr
 * @date 2024/8/1
 */
public enum ELoginType {

    /**
     * 账号密码
     */
    PASSWORD("1", "PASSWORD"),

    /**
     * 码云
     */
    GITEE("2", "GITEE"),

    /**
     * GITHUB
     */
    GITHUB("3", "GITHUB"),

    /**
     * QQ
     */
    QQ("4", "QQ"),

    /**
     * Gitee
     */
    WECHAT("5", "WECHAT");


    private final String code;
    private final String name;

    ELoginType(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}