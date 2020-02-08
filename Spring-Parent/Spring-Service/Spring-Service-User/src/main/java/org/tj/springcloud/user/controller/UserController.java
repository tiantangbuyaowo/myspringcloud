package org.tj.springcloud.user.controller;


import org.springframework.beans.factory.annotation.Required;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.tj.springcloud.common.model.userservice.vo.AddUserFormVo;
import org.tj.springcloud.common.util.HttpResult;
import org.tj.springcloud.user.service.UserService;

import javax.annotation.Resource;

@RestController
@CrossOrigin
@RequestMapping("/userService")
public class UserController {

    /**
     * 注入用户服务
     */
    @Resource
    private UserService userService;

    //@PreAuthorize("hasAnyAuthority('USER_ADD')")
    @GetMapping("/findUserByLogInName/{logInName}")
    public HttpResult findUserByLogInName(@PathVariable("logInName") String logInName) {
        //int i = 1/0;
        return HttpResult.OK().data(userService.findUserByLogInName(logInName));
    }

    @PreAuthorize("hasAnyAuthority('USER_ADD')")
    @PostMapping("/user")
    public HttpResult addNewUser(@RequestBody(required = false) AddUserFormVo addUserVo) {
        //int i = 1/0;
        return HttpResult.OK();
    }


}
