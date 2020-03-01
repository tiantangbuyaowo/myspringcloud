package org.tj.springcloud.search;

//import com.codingapi.txlcn.tc.config.EnableDistributedTransaction;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.concurrent.LinkedBlockingQueue;


/**
 * Created by tangjing on 2019/2/27.
 */
@EnableEurekaClient
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableFeignClients
//@EnableDistributedTransaction
@MapperScan("org.tj.springcloud.search.mapper")
@ComponentScan(basePackages = {"org.tj.**"})
@EnableAsync
public class Application {

    public static void main(String[] args) {


        SpringApplication.run(Application.class);
    }


}