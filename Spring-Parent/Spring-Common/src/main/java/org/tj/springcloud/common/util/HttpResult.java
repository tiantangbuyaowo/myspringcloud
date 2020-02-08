package org.tj.springcloud.common.util;

import lombok.Data;

/**
 * @author tangjing
 * @desc
 * @date 2019/3/11.
 */
@Data
public class HttpResult<T> {


    /**
     * @描述
     * @参数 400未知错误
     * @返回值
     * @创建人 tangjing
     * @创建日期 2019/3/11
     * @创建时间 22:29
     */
    public static final int UNKNOWERROR = 400;

    public static final int SUCCESS = 0;

    public static final String SUCCESS_MSG = "success";

    public static final String FAIL_MSG = "error";

    private int code;

    private String msg;

    private T data;


    public static HttpResult OK() {
        HttpResult result = new HttpResult();
        result.code = SUCCESS;
        result.msg = SUCCESS_MSG;
        return result;
    }

    public HttpResult data(T data) {
        this.data = data;
        return this;
    }


    /**
     * @描述
     * @参数 啥都没有的空错误
     * @返回值
     * @创建人 tangjing
     * @创建日期 2019/3/12
     * @创建时间 21:37
     */
    public static HttpResult ERROR()

    {
        return ERROR( UNKNOWERROR, FAIL_MSG );
    }

    /**
     * @描述
     * @参数 带有错误信息
     * @返回值
     * @创建人 tangjing
     * @创建日期 2019/3/12
     * @创建时间 21:37
     */
    public static HttpResult ERROR(String msg)

    {
        return ERROR( UNKNOWERROR, msg );
    }

    /**
     * @描述
     * @参数 带有错误信息和编码
     * @返回值
     * @创建人 tangjing
     * @创建日期 2019/3/12
     * @创建时间 21:37
     */
    public static HttpResult ERROR(int code, String msg)

    {
        HttpResult result = new HttpResult();
        result.code = code;
        result.msg = msg;
        return result;
    }

    public boolean success() {
        return this.code == SUCCESS;
    }


}
