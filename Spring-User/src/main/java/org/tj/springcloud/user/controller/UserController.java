package org.tj.springcloud.user.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tj.springcloud.common.model.userservice.User;
import org.tj.springcloud.user.mapper.UserMapper;
import org.tj.springcloud.user.service.UserService;


import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * @author tangjing
 * @desc
 * @date 2019/2/28.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping("/hi")
    public long hi() {
        User user = new User();
        user.setId(16);
        return userService.selectUser(user).getId();
    }


}
