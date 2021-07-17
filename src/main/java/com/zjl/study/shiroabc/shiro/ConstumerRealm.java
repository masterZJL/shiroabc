package com.zjl.study.shiroabc.shiro;

import com.zjl.study.shiroabc.entity.Flower;
import com.zjl.study.shiroabc.service.FlowerService;
import com.zjl.study.shiroabc.utils.ApplicationContextUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.util.ObjectUtils;

public class ConstumerRealm extends AuthorizingRealm {
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String principal = (String) principalCollection.getPrimaryPrincipal();
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.addRole("user");
        authorizationInfo.addStringPermission("user:*:*");
        return authorizationInfo;
//        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        FlowerService flowerService = (FlowerService) ApplicationContextUtils.getBean("flowerService");
        String principal = (String) authenticationToken.getPrincipal();
        Flower flower = flowerService.findByUsername(principal);
        if (!ObjectUtils.isEmpty(flower)) {
            return new SimpleAuthenticationInfo(principal, flower.getPassword(), ByteSource.Util.bytes(flower.getSalt()), this.getName());
        }
        return null;
    }
}
