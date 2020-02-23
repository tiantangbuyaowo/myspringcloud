package org.tj.springcloud.common.model.base;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author tangjing
 * @desc 分页基类
 * @date 2019/3/21.
 */
@Getter
@Setter
public class Page {

    protected long total;
    protected long size = 10;
    protected long current = 1;

}
