package com.zxk175.stock;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author zxk175
 * @since 2023-04-23 23:43
 */
@Slf4j
@EnableFeignClients
@EnableDiscoveryClient
@MapperScan("com.zxk175.stock.dao")
@SpringBootApplication(scanBasePackages = {"com.zxk175"}, exclude = DataSourceAutoConfiguration.class)
public class StockServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(StockServiceApplication.class, args);
    }

}
