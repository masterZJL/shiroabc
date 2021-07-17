package com.zjl.study.shiroabc.config;

import com.zjl.study.shiroabc.shiro.ConstumerRealm;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ShiroConfig  {

    //  shiroFilter
    // securityManager
    // realm

    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(DefaultWebSecurityManager defaultWebSecurityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);
        Map<String, String> map = new HashMap<>();
        map.put("/register", "anon");
        map.put("/dologin", "anon");
        map.put("/doregister", "anon");
        map.put("/login", "anon");
        map.put("/**", "authc");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
        shiroFilterFactoryBean.setLoginUrl("login");
        return shiroFilterFactoryBean;
    }

    @Bean
    public DefaultWebSecurityManager getDefaultWebSecurityManager(Realm realm) {
        DefaultWebSecurityManager sm = new DefaultWebSecurityManager();
        sm.setRealm(realm);
        return sm;
    }

    @Bean
    public Realm getRealm() {
        ConstumerRealm realm = new ConstumerRealm();
        HashedCredentialsMatcher cm = new HashedCredentialsMatcher("md5");
        cm.setHashIterations(1024);
        realm.setCredentialsMatcher(cm);
        return realm;
    }

}
