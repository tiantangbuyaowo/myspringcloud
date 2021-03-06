package org.tj.springcloud.user.oauth.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.tj.springcloud.common.util.HttpResult;
import org.tj.springcloud.user.oauth.client.UserClient;
import org.tj.springcloud.user.oauth.util.UserJwt;

import javax.annotation.Resource;

/*****
 * 自定义授权认证类
 */
@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    ClientDetailsService clientDetailsService;

    @Resource
    private UserClient userClient;

    /****
     * 自定义授权认证
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //取出身份，如果身份为空说明没有认证
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        //没有认证统一采用httpbasic认证，httpbasic中存储了client_id和client_secret，开始认证client_id和client_secret
        if (authentication == null) {
            ClientDetails clientDetails = clientDetailsService.loadClientByClientId(username);
            if (clientDetails != null) {
                //秘钥
                String clientSecret = clientDetails.getClientSecret();
                //静态方式
                //return new User(username,new BCryptPasswordEncoder().encode(clientSecret), AuthorityUtils.commaSeparatedStringToAuthorityList(""));
                //数据库查找方式
                return new User(username, clientSecret, AuthorityUtils.commaSeparatedStringToAuthorityList(""));
            }
        }

        if (StringUtils.isEmpty(username)) {
            return null;
        }

        //根据用户名查询用户信息
        //String pwd = new BCryptPasswordEncoder().encode("itheima");
        HttpResult result = userClient.findUserByLogInName(username);
        if (result.success() && null != result.getData()) {
            org.tj.springcloud.common.model.userservice.User user = (org.tj.springcloud.common.model.userservice.User) result.getData();
            //创建User对象
           // String permissions = "goods_list,seckill_list";
            UserJwt userDetails = new UserJwt(username, user.getPassword(), AuthorityUtils.commaSeparatedStringToAuthorityList(user.getPressmions()));
            return userDetails;
        }

        return null;
    }

    public static void main(String[] args) {
        System.out.println(new BCryptPasswordEncoder().encode("heima"));
    }
}
