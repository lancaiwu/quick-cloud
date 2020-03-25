package com.lancaiwu.cloud.storecenterservice.client.user;

import feign.Logger;
import org.springframework.context.annotation.Bean;


/**
 * Created with IntelliJ IDEA.
 * User: lancaiwu
 * Email: lancaiwu@gmail.com
 * Date: 2020-03-17
 * Time: 15:01
 * Description: 设置user-center-service 的  feign日志
 */
public class UserCenterFeignConfig {

    @Bean
    public Logger.Level level() {
        // 设置Feign的日志级别为FULL
        return Logger.Level.FULL;
    }
}
