package com.lancaiwu.cloud.limithystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;
import org.springframework.context.annotation.Configuration;

/**
 * 集合 hystrix、HystrixDashboard、Turbine 的 熔断器
 * 因为超时或者异常的机制发生，会进行重试 ，feign默认重试次数是5次，100ms一次
 * 所以在写接口的时候，需要对接口增加幂等性
 * dashboard :   http://localhost:11000//hystrix
 * turbine: http://localhost:11000/turbine.stream
 * 被监控者由于是Springboot2.0以上，所以需要修改监控地址为 hystrix.stream
 * 该项目的 yml 配置文件 turbine:instanceUrlSuffix 也要配置为 /hystrix.stream
 **/
@Configuration
@EnableEurekaClient
@EnableTurbine
@EnableHystrixDashboard
@SpringBootApplication
public class LimitHystrixApplication {

    public static void main(String[] args) {
        SpringApplication.run(LimitHystrixApplication.class, args);
    }

}
