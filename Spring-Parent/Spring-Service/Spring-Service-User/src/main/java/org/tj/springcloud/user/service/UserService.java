package org.tj.springcloud.user.service;

import org.tj.springcloud.common.model.userservice.User;

public interface UserService {
    /**
     * 根据用户名查询用户
     *
     * @param logInName
     * @return
     */
    User findUserByLogInName(String logInName);
}
