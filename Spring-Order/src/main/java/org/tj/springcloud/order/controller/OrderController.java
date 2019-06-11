package org.tj.springcloud.order.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tj.springcloud.common.exception.CloudException;
import org.tj.springcloud.common.util.HttpResult;
import org.tj.springcloud.order.service.OrderService;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * Created by tangjing on 2019/6/3.
 */
@RestController
public class OrderController {


    @Resource
    private OrderService orderService;

    @PostMapping("/order")
    public HttpResult createOrder(String goodid) {
        try {

            //检查库存

            orderService.createOrder(goodid);
            return HttpResult.OK().data( "ok" );
        } catch (Exception e) {
            e.printStackTrace();
            if (e instanceof CloudException) {
                return HttpResult.ERROR( e.getMessage() );
            }
            return HttpResult.ERROR( e.getMessage() );
        }
    }


}
