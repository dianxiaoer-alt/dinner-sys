package com.dinner.admin.ao.impl;

import com.dinner.admin.config.JasyptConfig;
import com.dinner.admin.feign.UserFeign;
import com.dinner.commons.domain.AdminUser;
import com.dinner.commons.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * SpringSecurity安全框架登录接口实现
 */
@Service
@Slf4j
public class AdminUserDetailServiceImpl implements UserDetailsService {
    @Autowired
    private UserFeign userFeign;
    @Autowired
    private JasyptConfig jasyptConfig;

    @Autowired
    private PasswordEncoder encoder;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Result<AdminUser> res = userFeign.queryUserByUserName(username);
        AdminUser adminUser = res.getData();
        if(adminUser == null){
            throw new UsernameNotFoundException("用户名不存在");
        }else{
            //目前只做admin权限
            //password解密  原来为jasypt解密，SpringSecurity前端登录将密码自动加密，所以要再次加密
            log.info("password解密："+jasyptConfig.decyptPwd(adminUser.getPassword()));
            String encodePassword = encoder.encode(jasyptConfig.decyptPwd(adminUser.getPassword()));
            return new User(username,encodePassword, AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
        }
    }
}
