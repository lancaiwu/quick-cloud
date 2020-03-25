package com.lancaiwu.cloud.baseservicecore.excetion;

import com.lancaiwu.cloud.baseservicecore.eums.APIResultCodeEnums;

/**
 * Created with IntelliJ IDEA.
 * User: lancaiwu
 * Email: lancaiwu@gmail.com
 * Date: 2020-03-13
 * Time: 16:58
 * Description: 基础异常类
 */
public class BaseException extends RuntimeException {

    private Integer code;

    public BaseException(Integer code) {
        super(APIResultCodeEnums.fromValue(code));
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}
