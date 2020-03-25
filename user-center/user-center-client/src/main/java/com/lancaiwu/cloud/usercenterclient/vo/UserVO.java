package com.lancaiwu.cloud.usercenterclient.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 * User: lancaiwu
 * Email: lancaiwu@gmail.com
 * Date: 2020-03-11
 * Time: 15:10
 * Description: No Description
 */
@ApiModel(value = "用户信息VO")
@Data
public class UserVO {
    @ApiModelProperty(value = "用户名", required = true, example = "lcw")
    private String username;
    @ApiModelProperty(value = "用户id", required = true, example = "123456464846565113156")
    private String id;
}
