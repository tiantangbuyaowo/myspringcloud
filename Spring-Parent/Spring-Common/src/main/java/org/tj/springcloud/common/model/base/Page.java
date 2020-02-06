package org.tj.springcloud.common.model.base;

import lombok.Data;

/**
 * @author tangjing
 * @desc 分页基类
 * @date 2019/3/21.
 */
@Data
public class Page {

    /**
     * @描述
     * @参数 当前页码
     * @返回值
     * @创建人 tangjing
     * @创建日期 2019/3/21
     * @创建时间 20:54
     */
    protected int pageCurrent = 1;
    /**
     * @描述
     * @参数 每页大小
     * @返回值
     * @创建人 tangjing
     * @创建日期 2019/3/21
     * @创建时间 20:54
     */
    protected int pageSize = 10;
    /**
     * @描述
     * @参数 总页码
     * @返回值
     * @创建人 tangjing
     * @创建日期 2019/3/21
     * @创建时间 20:54
     */
    protected int pageTotal = 0;

}
