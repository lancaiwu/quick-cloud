package com.lancaiwu.cloud.storecenterclient.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * Created with IntelliJ IDEA.
 * User: lancaiwu
 * Email: lancaiwu@gmail.com
 * Date: 2020-03-14
 * Time: 18:12
 * Description:新增店铺请求类
 */
@ApiModel("新增店铺请求类")
@Data
public class AddStoreReq {
    @ApiModelProperty(value = "店铺名", required = true, example = "胡桃里")
    @NotBlank(message = "店铺名不能为空")
    private String storeName;
    @ApiModelProperty(value = "店铺介绍不能为空", required = true, example = "店铺介绍不能为空")
    private String storeDesc;
}
