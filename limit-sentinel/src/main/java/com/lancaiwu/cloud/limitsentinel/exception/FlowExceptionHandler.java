package com.lancaiwu.cloud.limitsentinel.exception;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.lancaiwu.cloud.baseservicecore.eums.APIResultCodeEnums;
import com.lancaiwu.cloud.baseservicecore.pojo.APIResponse;

/**
 * Created with IntelliJ IDEA.
 * User: lancaiwu
 * Email: lancaiwu@gmail.com
 * Date: 2020-03-17
 * Time: 18:26
 * Description: 异常处理
 */
public class FlowExceptionHandler {
    public static APIResponse<Object> returnResult(BlockException ex) {
        ex.printStackTrace();
        return new APIResponse<>(APIResultCodeEnums.SYSTEM_IS_BUSY);
    }
}
