package org.tj.springcloud.user.oauth.service;


import org.tj.springcloud.user.oauth.util.AuthToken;

public interface AuthService {

    AuthToken login(String username, String password, String clientId, String clientSecret);
}
