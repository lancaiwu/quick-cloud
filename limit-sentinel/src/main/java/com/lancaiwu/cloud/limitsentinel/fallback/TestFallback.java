package com.lancaiwu.cloud.limitsentinel.fallback;

import com.lancaiwu.cloud.baseservicecore.eums.APIResultCodeEnums;
import com.lancaiwu.cloud.baseservicecore.pojo.APIResponse;

/**
 * Created with IntelliJ IDEA.
 * User: lancaiwu
 * Email: lancaiwu@gmail.com
 * Date: 2020-03-17
 * Time: 18:39
 * Description: No Description
 */
public class TestFallback {
    public APIResponse<Object> testFallback(String a) {
        return new APIResponse<>(APIResultCodeEnums.FAIL);
    }
}
