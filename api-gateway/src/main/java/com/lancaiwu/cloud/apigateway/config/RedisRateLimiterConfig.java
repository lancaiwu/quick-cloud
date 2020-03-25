package com.lancaiwu.cloud.apigateway.config;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Mono;

/**
 * Created with IntelliJ IDEA.
 * User: lancaiwu
 * Email: lancaiwu@gmail.com
 * Date: 2020-03-20
 * Time: 20:54
 * Description: 限流策略的配置类
 * RequestRateLimiter GatewayFilter 过滤器 配置类
 * 添加限流策略的配置类，
 * 两种策略
 * 1、一种是根据请求参数中的username进行限流，
 * 2、一种是根据访问IP进行限流
 */
@Configuration
public class RedisRateLimiterConfig {
    /**
     * 根据请求参数中的username进行限流
     *
     * @return
     */
//    @Bean(value = "userKeyResolver")
//    public KeyResolver userKeyResolver() {
//        return exchange -> Mono.just(exchange.getRequest().getQueryParams().getFirst("username"));
//    }

    /**
     * 根据访问ip进行限流
     *
     * @return
     */
    @Bean(value = "ipKeyResolver")
    public KeyResolver ipKeyResolver() {
        return exchange -> Mono.just(exchange.getRequest().getRemoteAddress().getHostName());
    }
}
