package com.lancaiwu.cloud.usercenterservice;

import com.codingapi.txlcn.tc.config.EnableDistributedTransaction;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

// 分布式事务LCN
@EnableDistributedTransaction
// 要增加扫描范围,否则依赖的项目注入无法生效
@SpringBootApplication(scanBasePackages = {"com.lancaiwu.cloud"})
@MapperScan("com.lancaiwu.cloud.usercenterservice.mapper")
@EnableFeignClients
@EnableEurekaClient
@EnableHystrix
@Configuration
public class UserCenterServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserCenterServiceApplication.class, args);
    }
}
