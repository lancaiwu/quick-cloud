package com.lancaiwu.cloud.storecenterservice;

import com.codingapi.txlcn.tc.config.EnableDistributedTransaction;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

// 分布式事务LCN
@EnableDistributedTransaction
@SpringBootApplication(scanBasePackages = {"com.lancaiwu.cloud"})
@MapperScan("com.lancaiwu.cloud.storecenterservice.mapper")
@EnableFeignClients // 开启ribbon
@EnableEurekaClient // 注册到eureka
@EnableHystrix // 开启熔断
public class StoreCenterServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(StoreCenterServiceApplication.class, args);
    }

}
