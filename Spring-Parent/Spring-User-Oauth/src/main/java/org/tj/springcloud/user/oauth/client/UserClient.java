package org.tj.springcloud.user.oauth.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.tj.springcloud.common.util.HttpResult;
import org.tj.springcloud.user.api.UserApi;
import org.tj.springcloud.user.oauth.client.back.UserServiceFallback;


@FeignClient(value = "user-service", fallback = UserServiceFallback.class)
public interface UserClient extends UserApi {

}
