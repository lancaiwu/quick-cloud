package com.lancaiwu.cloud.transactionlcn;

import com.codingapi.txlcn.tm.config.EnableTransactionManagerServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 基于LCN的 分布式事务
 * 添加lcn的lcn-tm依赖
 * 主类添加 @EnableTransactionManagerServer
 */
@EnableTransactionManagerServer
@SpringBootApplication
public class TransactionLcnApplication {

    public static void main(String[] args) {
        SpringApplication.run(TransactionLcnApplication.class, args);
    }

}
