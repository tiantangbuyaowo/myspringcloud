package org.tj.springcloud.getway.system.filter;


import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.tj.springcloud.getway.system.util.JwtUtil;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.Arrays;

@Component
public class AuthorizeFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        //1.获取请求对象
        ServerHttpRequest request = exchange.getRequest();
        //2.获取响应对象
        ServerHttpResponse response = exchange.getResponse();

        //3.判断当前的请求是否为登录请求,如果是,则直接放行
        if (request.getURI().getPath().contains("/oauth/login")) {
            //放行
            return chain.filter(exchange);
        }
        //4.获取当前的所有请求头信息
        HttpHeaders headers = request.getHeaders();

        //客户头文件里不能自己设置直接请求的token，如果自己直接设置的，就直接认为他没权限
        if (StringUtils.isEmpty(headers.getFirst("Authorization"))) {
            //5.获取jwt令牌信息
            String jwtToken = headers.getFirst("token");

            //6.判断当前令牌是否存在,
            if (StringUtils.isEmpty(jwtToken)) {
                //如果不存在,则向客户端返回错误提示信息
                response.setStatusCode(HttpStatus.UNAUTHORIZED);
                return response.setComplete();
            }

            if (!jwtToken.startsWith("bearer ")) { //如果不是以bearer 开头
                jwtToken = "bearer " + jwtToken;
            }
            // header中添加token数据
            ServerHttpRequest host = exchange.getRequest().mutate().header("Authorization", jwtToken).build();
            exchange = exchange.mutate().request(host).build();
        } else {
            response.setStatusCode(HttpStatus.UNAUTHORIZED);
            return response.setComplete();
        }

        //6.2 如果令牌存在,则放行
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
