package com.lancaiwu.cloud.baseservicecore.pojo;


import com.lancaiwu.cloud.baseservicecore.eums.APIResultCodeEnums;
import com.lancaiwu.cloud.baseservicecore.excetion.BaseException;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: lancaiwu
 * Email: lancaiwu@gmail.com
 * Date: 2020-03-12
 * Time: 18:24
 * Description: API通用返回对象
 */
@ApiModel(value = "接口返回对象", description = "接口返回对象")
@Data
public class APIResponse<T> implements Serializable {
    private static final long serialVersionUID = 697980425283889417L;
    @ApiModelProperty(value = "返回码")
    private Integer code;
    @ApiModelProperty(value = "描述")
    private String msg;
    @ApiModelProperty(value = "响应时间")
    private Date timestamp;
    @ApiModelProperty(value = "结果集")
    private T data;

    public APIResponse(T data) {
        this.data = data;
        timestamp = new Date();
        this.code = APIResultCodeEnums.SUCCESS.getCode();
        this.msg = APIResultCodeEnums.SUCCESS.getMsg();
    }

    public APIResponse() {
        timestamp = new Date();
        this.code = APIResultCodeEnums.SUCCESS.getCode();
        this.msg = APIResultCodeEnums.SUCCESS.getMsg();
    }

    public APIResponse(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
        timestamp = new Date();
    }

//    public APIResponse(Integer code) {
//        this.code = code;
//        this.msg = APIResultCodeEnums.fromValue(code);
//        timestamp = new Date();
//    }

    public APIResponse(APIResultCodeEnums apiResultCodeEnums) {
        this.code = apiResultCodeEnums.getCode();
        this.msg = apiResultCodeEnums.getMsg();
        timestamp = new Date();
    }

    public APIResponse(BaseException e) {
        this.code = e.getCode();
        this.msg = e.getMessage();
        timestamp = new Date();
    }

}
