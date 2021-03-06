package com.lancaiwu.cloud.baseservicecore.excetion;

import com.lancaiwu.cloud.baseservicecore.eums.APIResultCodeEnums;
import com.lancaiwu.cloud.baseservicecore.pojo.APIResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: lancaiwu
 * Email: lancaiwu@gmail.com
 * Date: 2020-03-13
 * Time: 16:36
 * Description: 基础异常捕获处理器
 */
@Slf4j
@RestControllerAdvice
public class BaseExceptionHandler {

    @ExceptionHandler(Exception.class)
    public APIResponse<Object> exceptionHandler(Exception e) {
        log.error("出现Exception异常", e);
        return new APIResponse<>(APIResultCodeEnums.FAIL);
    }

    /**
     * 基础异常处理
     *
     * @return
     */
    @ExceptionHandler(BaseException.class)
    public APIResponse<Object> baseExceptionHandler(BaseException e) {
        log.error("出现BaseException异常,code: " + e.getCode(), e);
        return new APIResponse<>(e);
    }

    // 被 迁移至 GlobalErrorController 类进行处理
    // @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    // @ExceptionHandler(NoHandlerFoundException.class)
//    @ExceptionHandler(UnsupportedOperationException.class)
//    public APIResponse httpRequestMethodNotSupportedExceptionHandler(UnsupportedOperationException e) {
//        log.error("不支持当前请求方式,code: " + APIResultCodeEnums.NOT_FOUND.getCode(), e);
//        return new APIResponse<>(APIResultCodeEnums.NOT_FOUND.getCode());
//    }

    /**
     * 参数校验异常拦截
     *
     * @param e
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public APIResponse<Object> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        log.error("参数错误异常", e.getMessage(), e);
        BindingResult bindingResult = e.getBindingResult();
        ObjectError firstError = null;
        if (bindingResult.hasErrors()) {
            List<ObjectError> errors = bindingResult.getAllErrors();
            firstError = errors.get(0);
        }
        APIResponse<Object> apiResponse = new APIResponse<>(APIResultCodeEnums.PARAMS_ERROR);
        if (firstError != null) {
            String errorMsg = firstError.getDefaultMessage();
            if (!ObjectUtils.isEmpty(errorMsg)) {
                try {
                    apiResponse.setMsg(errorMsg);
                } catch (NumberFormatException e3) {
                    log.error("参数错误异常的NumberFormatException异常", e.getMessage(), e);
                    apiResponse.setMsg(e.getMessage());
                }
            }

        }

        return apiResponse;
    }
}
