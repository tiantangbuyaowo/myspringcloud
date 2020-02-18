package org.tj.springcloud.seckill;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@EnableEurekaClient
@SpringBootApplication
@EnableFeignClients
@MapperScan("org.tj.springcloud.seckill.mapper")
@ComponentScan(basePackages = {"org.tj.**"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }


}
