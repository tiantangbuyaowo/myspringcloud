package org.tj.springcloud.user.oauth.client.back;

import org.springframework.stereotype.Component;
import org.tj.springcloud.common.util.HttpResult;
import org.tj.springcloud.user.oauth.client.UserClient;

/**
 * Created by tangjing on 2019/6/4.
 */
@Component
public class UserServiceFallback implements UserClient {

    @Override
    public HttpResult findUserByLogInName(String logInName) {
        return HttpResult.ERROR("服务器忙");
    }
}
