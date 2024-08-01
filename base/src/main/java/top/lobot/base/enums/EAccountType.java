package top.lobot.base.enums;

/**
 *
 * @author ykr
 * @date 2024/8/1
 */
public enum EAccountType {

    /**
     * 邮箱
     */
    EMAIL("EMAIL", "邮箱"),

    /**
     * QQ号
     */
    QQ("QQ", "QQ号"),

    /**
     * QQ群
     */
    QQ_GROUP("QQG", "QQ群"),

    /**
     * Github
     */
    GITHUB("GITHUB", "Github"),

    /**
     * Gitee
     */
    GITEE("GITEE", "Gitee"),

    /**
     * 微信
     */
    WECHAT("WECHAT", "微信");


    private final String code;
    private final String name;

    EAccountType(String code, String name) {
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