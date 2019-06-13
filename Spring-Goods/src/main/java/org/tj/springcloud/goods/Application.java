package org.tj.springcloud.goods;

import com.codingapi.txlcn.tc.config.EnableDistributedTransaction;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Created by tangjing on 2019/2/27.
 */


@EnableEurekaClient
@SpringBootApplication
@EnableDistributedTransaction
@MapperScan("org.tj.springcloud.goods.mapper")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }


}
