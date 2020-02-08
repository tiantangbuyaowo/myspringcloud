package org.tj.springcloud.user.oauth.controller;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tj.springcloud.common.util.HttpResult;
import org.tj.springcloud.user.oauth.service.AuthService;
import org.tj.springcloud.user.oauth.util.AuthToken;
import org.tj.springcloud.user.oauth.util.CookieUtil;

import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/oauth")
public class AuthController {

   @Autowired
    private AuthService authService;

    @Value("${auth.clientId}")
    private String clientId;

    @Value("${auth.clientSecret}")
    private String clientSecret;

    @Value("${auth.cookieDomain}")
    private String cookieDomain;

    @Value("${auth.cookieMaxAge}")
    private int cookieMaxAge;

    @RequestMapping("/toLogin")
    public String toLogin() {
        return "login";
    }


    @RequestMapping("/login")
    @ResponseBody
    public HttpResult login(String username, String password, HttpServletResponse response) {
        //校验参数
        if (StringUtils.isEmpty(username)) {
            throw new RuntimeException("请输入用户名");
        }
        if (StringUtils.isEmpty(password)) {
            throw new RuntimeException("请输入密码");
        }
        //申请令牌 authtoken
        AuthToken authToken = authService.login(username, password, clientId, clientSecret);

        //将jti的值存入cookie中
        this.saveJtiToCookie(authToken.getJti(), response);

        //返回结果
        return new HttpResult().OK().data(authToken);
    }

    //将令牌的断标识jti存入到cookie中
    private void saveJtiToCookie(String jti, HttpServletResponse response) {
        CookieUtil.addCookie(response, cookieDomain, "/", "uid", jti, cookieMaxAge, false);
    }
}
