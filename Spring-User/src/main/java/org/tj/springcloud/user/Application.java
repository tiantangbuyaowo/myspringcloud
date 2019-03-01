package org.tj.springcloud.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Created by tangjing on 2019/2/27.
 */


@EnableEurekaClient
@SpringBootApplication
//@MapperScan("org.tj.springcloud.user.mapper")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }


}
