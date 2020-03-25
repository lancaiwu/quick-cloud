package com.lancaiwu.cloud.baseservicecore.eums;

/**
 * Created with IntelliJ IDEA.
 * User: lancaiwu
 * Email: lancaiwu@gmail.com
 * Date: 2020-03-13
 * Time: 16:43
 * Description: 接口响应 枚举类
 */
public enum APIResultCodeEnums {
    SUCCESS(200, "成功"),
    PARAMS_ERROR(400, "参数错误"),
    NOT_FOUND(404, "请求路径不存在"),
    NOT_EXIST(405, "资源不存在"),
    FAIL(500, "失败"),
    SYSTEM_IS_BUSY(503, "系统繁忙,请稍后再试"),
    SYSTEM_NOT_EXIST(504, "远程服务访问失败"),

    /**
     * ================= 10000 - 19999 ========================
     * ================= 店铺中心 错 误============================
     */
    STORE_NOT_EXIST(10000, "店铺不存在"),

    /**
     * ================= 20000 - 29999 ========================
     * ================= 用户中心 错 误============================
     */
    USER_NOT_EXIST(20000, "用户不存在");

    private Integer code;
    private String msg;

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    APIResultCodeEnums(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * 根据code查询描述
     *
     * @param code
     * @return
     */
    public static String fromValue(Integer code) {
        for (APIResultCodeEnums e : values()) {
            if (e.code.equals(code)) {
                return e.getMsg();
            }
        }
        return "未知返回码";
    }
}
