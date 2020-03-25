package com.lancaiwu.cloud.apigateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: lancaiwu
 * Email: lancaiwu@gmail.com
 * Date: 2020-03-20
 * Time: 20:44
 * Description: 服务降级的处理类
 */
@RestController
public class FallbackController {
    /**
     * 在 yml 配置文件里面配置了这个方法为降级处理
     *
     * @return
     */
    @GetMapping("/fallback")
    public Object fallback() {
        Map<String, Object> result = new HashMap<>();
        result.put("data", null);
        result.put("msg", "Get request fallback!");
        result.put("code", 500);
        return result;
    }
}
