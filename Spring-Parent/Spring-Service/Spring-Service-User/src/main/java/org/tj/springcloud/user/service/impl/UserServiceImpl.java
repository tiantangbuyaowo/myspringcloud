package org.tj.springcloud.user.service.impl;

import org.springframework.stereotype.Service;
import org.tj.springcloud.common.model.userservice.User;
import org.tj.springcloud.user.mapper.UserMapper;
import org.tj.springcloud.user.service.UserService;

import javax.annotation.Resource;


/**
 * 用户Service
 */
@Service("userService")
public class UserServiceImpl implements UserService {


    @Resource
    private UserMapper userMapper;


    @Override
    public User findUserByLogInName(String logInName) {
        User user = userMapper.findUserByLogInName(logInName);
        if (null != user) {
            //这个是查询这个用户拥有的权限，因为现在没有权限管理，所以这里写死
            user.setPressmions("USER_ADD,USER_UPDATE");
        }
        return user;
    }
}
