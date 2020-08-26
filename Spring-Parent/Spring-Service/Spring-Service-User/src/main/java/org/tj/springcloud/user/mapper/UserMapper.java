package org.tj.springcloud.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.tj.springcloud.common.model.userservice.User;

/**
 * 用户操作mapper
 */
public interface UserMapper extends BaseMapper<User> {
    User findUserByLogInName(String logInName);
}
