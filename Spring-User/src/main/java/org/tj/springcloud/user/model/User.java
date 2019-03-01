package org.tj.springcloud.user.model;

import lombok.Data;

/**
 * @author tangjing
 * @desc
 * @date 2019/2/28.
 */
//@Data
public class User {
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
