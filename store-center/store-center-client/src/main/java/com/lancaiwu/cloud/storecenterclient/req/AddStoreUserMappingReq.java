package com.lancaiwu.cloud.storecenterclient.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * Created with IntelliJ IDEA.
 * User: lancaiwu
 * Email: lancaiwu@gmail.com
 * Date: 2020-03-16
 * Time: 16:43
 * Description: 新增 用户与店铺的 映射
 */
@Data
@ApiModel("新增用户与店铺映射的请求类")
public class AddStoreUserMappingReq {
    @ApiModelProperty(value = "用户id", required = true, example = "4564654564646")
    @NotBlank(message = "用户id不能为空")
    private String userId;
    @ApiModelProperty(value = "店铺id", required = true, example = "33335556659898")
    @NotBlank(message = "店铺id不能为空")
    private String storeId;
}
