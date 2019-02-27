package org.tj.springcloud.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.tj.springcloud.web.service.UserService;

/**
 * Created by tangjing on 2019/2/27.
 */
@RestController
public class DcController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    public String sayHi(@RequestParam String name) {
        return userService.getUserInfo(name);
    }

}
