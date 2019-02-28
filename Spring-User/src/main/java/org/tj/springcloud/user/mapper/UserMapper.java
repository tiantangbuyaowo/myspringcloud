package org.tj.springcloud.user.mapper;

import org.tj.springcloud.user.model.User;

/**
 * @author tangjing
 * @desc
 * @date 2019/2/28.
 */
public interface UserMapper {

    public User selectUser(User user);
}
