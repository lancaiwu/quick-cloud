package com.lancaiwu.cloud.limitsentinel.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.lancaiwu.cloud.baseservicecore.pojo.APIResponse;
import com.lancaiwu.cloud.limitsentinel.exception.FlowExceptionHandler;
import com.lancaiwu.cloud.limitsentinel.fallback.TestFallback;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 * User: lancaiwu
 * Email: lancaiwu@gmail.com
 * Date: 2020-03-17
 * Time: 17:16
 * Description: No Description
 */
@RestController
@RequestMapping("/test")
public class TestController {
    // 规则持久化  没写

    /**
     * 要先访问一遍这个接口，才会出现在sentinel控制台
     *
     * @return
     */
    @SentinelResource(value = "hello", blockHandlerClass = FlowExceptionHandler.class, blockHandler = "returnResult", fallback = "testFallback", fallbackClass = TestFallback.class)
    @RequestMapping("/hello")
    public APIResponse<Object> hello(String a) {
        return new APIResponse<>();
    }

    @SentinelResource(value = "hello2", blockHandlerClass = FlowExceptionHandler.class, blockHandler = "returnResult")
    @RequestMapping("/hello2")
    public APIResponse<Object> hello2() {
        return new APIResponse<>();
    }

    @SentinelResource(value = "hello3", blockHandlerClass = FlowExceptionHandler.class, blockHandler = "returnResult")
    @RequestMapping("/hello3")
    public APIResponse<Object> hello3() {
        return new APIResponse<>();
    }

    @SentinelResource(value = "hello4", blockHandlerClass = FlowExceptionHandler.class, blockHandler = "returnResult")
    @RequestMapping("/hello4")
    public APIResponse<Object> hello4() {
        return new APIResponse<>();
    }
}
