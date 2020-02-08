package org.tj.springcloud.user.mapper;

import org.tj.springcloud.common.model.userservice.User;

/**
 * 用户操作mapper
 */
public interface UserMapper {
    User findUserByLogInName(String logInName);
}
