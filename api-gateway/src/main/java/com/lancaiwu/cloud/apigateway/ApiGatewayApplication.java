package com.lancaiwu.cloud.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Gateway 提供了两种不同的方式用于配置路由，一种是通过yml文件来配置，另一种是通过Java Bean来配置，
 */
/**
 * Route Predicate 的使用
 * 路由匹配规则： predicates
 * 1、在指定时间之后的请求会匹配该路由 - After=2019-12-29T18:30:00+08:00[Asia/Shanghai]
 * 2、在指定时间之前的请求会匹配该路由。 - Between=2019-12-29T18:30:00+08:00[Asia/Shanghai], 2019-12-30T18:30:00+08:00[Asia/Shanghai]
 * 3、带有指定Cookie的请求会匹配该路由 - Cookie=username,jourwon
 * 4、带有指定请求头的请求会匹配该路由 - Header=X-Request-Id, \d+
 * 5、带有指定Host的请求会匹配该路由 - Host=**.jourwon.com
 * 6、发送指定方法的请求会匹配该路由 - Method=GET
 * 7、发送指定路径的请求会匹配该路由  - Path=/user/{id}
 * 8、带指定查询参数的请求可以匹配该路由 - Query=username
 * 9、从指定远程地址发起的请求可以匹配该路由  - RemoteAddr=192.168.1.1/24
 * 10、使用权重来路由相应请求  - Weight=group1, 2
 *
 * Route Predicate 使用  的 yml 完整例子：
 * spring:
 *   cloud:
 *     gateway:
 *       routes:
 *         - id: cookie_route
 *           uri: ${service-url.user-service}
 *           predicates:
 *             - Cookie=username,jourwon
 *
 */

/**
 * Route Filter 的使用   filters
 * 路由过滤器可用于修改进入的HTTP请求和返回的HTTP响应.
 * 路由过滤器只能指定路由进行使用。Spring Cloud Gateway 内置了多种路由过滤器，他们都由GatewayFilter的工厂类来产生
 * filters 的 匹配规则
 * 1、AddRequestParameter GatewayFilter 给请求添加参数的过滤器   - AddRequestParameter=username, jourwon   ，配置会对GET请求添加username=jourwon的请求参数
 * 2、StripPrefix GatewayFilter 对指定数量的路径前缀进行去除的过滤器   - StripPrefix=2   配置会把以/user-service/开头的请求的路径去除两位
 * 3、PrefixPath GatewayFilter 会对原有路径进行增加操作的过滤器，与StripPrefix过滤器恰好相反 - PrefixPath=/user
 * 4、Hystrix GatewayFilter ,Hystrix 过滤器允许你将断路器功能添加到网关路由中，使你的服务免受级联故障的影响，并提供服务降级处理，需要添加hystrix的包，并配置 filter
 * 5、RequestRateLimiter GatewayFilter ，添加 redis-reactive 架包， RequestRateLimiter 过滤器可以用于限流，使用RateLimiter实现来确定是否允许当前请求继续进行，如果请求太大默认会返回HTTP 429-太多请求状态
 */
@EnableEurekaClient
@SpringBootApplication
public class ApiGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayApplication.class, args);
    }

}
