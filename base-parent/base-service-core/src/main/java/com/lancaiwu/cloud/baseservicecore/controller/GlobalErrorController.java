package com.lancaiwu.cloud.baseservicecore.controller;

import com.lancaiwu.cloud.baseservicecore.eums.APIResultCodeEnums;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: lancaiwu
 * Email: lancaiwu@gmail.com
 * Date: 2020-03-14
 * Time: 10:06
 * Description: controller发生错误的全局捕获，比如 404 、401
 */
@Slf4j
@Controller
public class GlobalErrorController extends BasicErrorController {

    public GlobalErrorController(ServerProperties serverProperties) {
        super(new DefaultErrorAttributes(), serverProperties.getError());
    }

    @RequestMapping
    @ResponseBody
    public ResponseEntity<Map<String, Object>> error(HttpServletRequest request) {
        HttpStatus status = this.getStatus(request);
        if (status == HttpStatus.NO_CONTENT) {
            return new ResponseEntity<>(status);
        } else {
            Map<String, Object> body = this.getErrorAttributes(request, this.isIncludeStackTrace(request, MediaType.ALL));
            log.error("请求地址无效 : " + request.getMethod() + "  " + body.get("path"));
            Map<String, Object> resultBody = new HashMap<>();
            resultBody.put("code", APIResultCodeEnums.NOT_FOUND.getCode());
            resultBody.put("msg", APIResultCodeEnums.NOT_FOUND.getMsg());
            resultBody.put("timestamp", body.get("timestamp"));
            resultBody.put("data", null);
            return new ResponseEntity<>(resultBody, status);
        }
    }
}
