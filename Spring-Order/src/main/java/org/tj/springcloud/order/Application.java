package org.tj.springcloud.order;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


/**
 * Created by tangjing on 2019/2/27.
 */
@EnableEurekaClient
@SpringBootApplication
@EnableFeignClients
@MapperScan("org.tj.springcloud.goods.mapper")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run( Application.class );
    }


}