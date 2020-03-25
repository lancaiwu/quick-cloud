package com.lancaiwu.cloud.usercenterclient.enums;

/**
 * Created with IntelliJ IDEA.
 * User: lancaiwu
 * Email: lancaiwu@gmail.com
 * Date: 2020-03-11
 * Time: 15:04
 * Description: No Description
 */
public enum UserEnum {
    USER_STATUS_ACTIVE(1, "正常"),
    USER_STATUS_DISABLE(2, "禁用");

    private Integer code;
    private String desc;


    UserEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public Integer getCode() {
        return code;
    }

    public static String fromValue(Integer code) {
        for (UserEnum e : values()) {
            if (e.code.equals(code)) {
                return e.getDesc();
            }
        }
        return null;
    }
}
