package org.tj.springcloud.web.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author tangjing
 * @desc
 * @date 2019/2/27.
 */
@FeignClient(value = "user-service")
public interface UserService {

    @RequestMapping(value = "/getUserInfo", method = RequestMethod.GET)
    String getUserInfo(@RequestParam(value = "name") String name);
}
