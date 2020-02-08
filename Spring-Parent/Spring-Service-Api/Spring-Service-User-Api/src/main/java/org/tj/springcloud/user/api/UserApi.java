package org.tj.springcloud.user.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.tj.springcloud.common.model.goodservice.Goods;
import org.tj.springcloud.common.model.userservice.User;
import org.tj.springcloud.common.util.HttpResult;

public interface UserApi {


    /**
     * 获取用户信息
     *
     * @param logInName
     */
    @GetMapping("/userService/findUserByLogInName/{logInName}")
    HttpResult<User> findUserByLogInName(@PathVariable("logInName") String logInName);

}
