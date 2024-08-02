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
    EMail("1", "邮箱"),

    /**
     * QQ号
     */
    QQNumber("2", "QQ号"),

    /**
     * QQ群
     */
    QQGroup("3", "QQ群"),

    /**
     * Github
     */
    Github("4", "Github"),

    /**
     * Gitee
     */
    Gitee("5", "Gitee"),

    /**
     * 微信
     */
    WeChat("6", "微信");


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