package org.tj.springcloud.goods;

//import com.codingapi.txlcn.tc.config.EnableDistributedTransaction;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by tangjing on 2019/2/27.
 */


@EnableEurekaClient
@SpringBootApplication
//@EnableCaching
@MapperScan("org.tj.springcloud.goods.mapper")
@ComponentScan(basePackages = {"org.tj.**"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }


}
