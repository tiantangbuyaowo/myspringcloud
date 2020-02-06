package org.tj.springcloud.common.exception;

/**
 * 自定义异常
 *
 * @author tangjing
 * @desc
 * @date 2019/3/11.
 */
public class CloudException extends RuntimeException {


    public CloudException(String message) {
        super(message);
    }
}
