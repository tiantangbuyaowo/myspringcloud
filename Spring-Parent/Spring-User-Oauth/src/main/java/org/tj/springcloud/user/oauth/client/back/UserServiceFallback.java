package org.tj.springcloud.user.oauth.client.back;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.tj.springcloud.common.util.HttpResult;
import org.tj.springcloud.user.oauth.client.UserClient;

/**
 * Created by tangjing on 2019/6/4.
 */
@Slf4j
@Component
public class UserServiceFallback implements UserClient {

    @Override
    public HttpResult findUserByLogInName(String logInName) {

        log.error("load user-service  findUserByLogInName error");
        return HttpResult.ERROR("服务器忙,请稍后再试");
    }
}
