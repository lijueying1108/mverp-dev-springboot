package com.mverp.shiro.config;

import com.mverp.shiro.realm.MVRealm;
import org.apache.shiro.cache.ehcache.EhCacheManager;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;

import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    @Bean
    public EhCacheManager cacheManager() {
        System.out.println("ShiroConfiguration.getEhCacheManager()");
        EhCacheManager em = new EhCacheManager();
        em.setCacheManagerConfigFile("classpath:shiro-ehcache.xml");
        return em;
    }

    @Bean
    public  MVRealm mvRealm() {
        MVRealm mvRealm = new MVRealm();
        return mvRealm;
    }

    @Bean
    public SessionManager sessionManager() {
        SessionManager sessionManager = new SessionManager();
        sessionManager.setDeleteInvalidSessions(true);
        sessionManager.setSessionValidationInterval(1800000);
        sessionManager.setGlobalSessionTimeout(1800000);
        sessionManager.setCacheManager(cacheManager());
        return  sessionManager;
    }

    @Bean
    public DefaultWebSecurityManager  securityManager() {
        DefaultWebSecurityManager securityManager  = new DefaultWebSecurityManager();
        securityManager .setRealm(mvRealm());
        securityManager .setCacheManager(cacheManager());
        securityManager .setSessionManager(sessionManager());
        return securityManager ;
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager){
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager());
        return authorizationAttributeSourceAdvisor;
    }
    @Bean
    public static DefaultAdvisorAutoProxyCreator getDefaultAdvisorAutoProxyCreator(){
        DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator=new DefaultAdvisorAutoProxyCreator();
        defaultAdvisorAutoProxyCreator.setUsePrefix(true);

        return defaultAdvisorAutoProxyCreator;
    }
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean() {
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        bean.setSecurityManager(securityManager());
        bean.setLoginUrl("/user/auth/login");

        Map<String, String> filterMap = new LinkedHashMap<>();
        filterMap.put("/user/auth/login","anon");
        filterMap.put("/**","anon");
        filterMap.put("/user/logout","logout");

        bean.setFilterChainDefinitionMap(filterMap);
        return  bean;
    }

}
