package org.tj.springcloud.user.service;

import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.tj.springcloud.common.model.userservice.User;
import org.tj.springcloud.user.mapper.UserMapper;

import javax.annotation.Resource;

/**
 * @author tangjing
 * @desc
 * @date 2019/2/27.
 */

@Service
public class UserService {

    @Resource
    private UserMapper userMapper;

    @Transactional
    public void addUser(User user) {
        userMapper.addUser(user);
    }


    public User selectUser(User user) {
        return userMapper.selectUser(user);
    }
}
