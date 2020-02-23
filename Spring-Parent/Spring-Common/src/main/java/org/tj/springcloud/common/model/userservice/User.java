package org.tj.springcloud.common.model.userservice;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Configurable;


import java.util.Date;

/**
 * @author tangjing
 * @desc
 * @date 2019/2/28.
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter

public class User {
    /**
     * 主键
     */


    private Integer id;
    /**
     * 用户名
     */


    private String username;
    /**
     * 密码，加密存储
     */


    private String password;
    /**
     * 注册手机号
     */


    private String phone;
    /**
     * 创建时间
     */


    private Date created;
    /**
     * 权限
     */


    private String pressmions;

}
