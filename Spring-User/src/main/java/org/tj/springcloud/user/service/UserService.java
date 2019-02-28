package org.tj.springcloud.user.service;

import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tangjing
 * @desc
 * @date 2019/2/27.
 */

@RestController
public class UserService {

    @RequestMapping("/getUserInfo")
    public String home(@RequestParam String name) {
        return "hi " + name;
    }


}
