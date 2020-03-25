package com.lancaiwu.cloud.usercenterclient.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * Created with IntelliJ IDEA.
 * User: lancaiwu
 * Email: lancaiwu@gmail.com
 * Date: 2020-03-12
 * Time: 16:30
 * Description: 新增用户的 Req
 */
@Data
@ApiModel(value = "新增用户Req类")
public class AddUserReq {
    /**
     * 属性名称	数据类型	默认值	说明
     * value	String	“”	属性简要说明
     * name	String	“”	运行覆盖属性的名称。重写属性名称
     * allowableValues	String	“”	限制参数可接收的值，三种方法，固定取值，固定范围
     * access	String	“”	过滤属性，参阅:io.swagger.core.filter.SwaggerSpecFilter
     * notes	String	“”	目前尚未使用
     * dataType	String	“”	参数的数据类型，可以是类名或原始数据类型，此值将覆盖从类属性读取的数据类型
     * required	boolean	false	是否为必传参数,false:非必传参数; true:必传参数
     * position	int	0	允许在模型中显示排序属性
     * hidden	boolean	false	隐藏模型属性，false:不隐藏; true:隐藏
     * example	String	“”	属性的示例值
     * readOnly	boolean	false	指定模型属性为只读，false:非只读; true:只读
     * reference	String	“”	指定对应类型定义的引用，覆盖指定的任何其他元数据
     * allowEmptyValue	boolean	false	允许传空值，false:不允许传空值; true:允许传空值
     */
    @ApiModelProperty(value = "用户名", required = true, example = "lcw")
    @NotBlank(message = "用户名不能为空")
    private String username;
    @NotBlank(message = "密码不能为空")
    @ApiModelProperty(value = "密码", required = true, example = "123456")
    private String password;
}
