package com.xxxx.flyserver.config.security.component;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * @program: fly
 * @description: 权限控制,判断用户角色
 * @author: cxf
 * @create: 2022-02-28 15:45
 **/
@Component
public class CustomerUrlDecisionManage implements AccessDecisionManager {
    @Override
    public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes) throws AccessDeniedException, InsufficientAuthenticationException {
        for(ConfigAttribute configAttribute:configAttributes){
            //当前url所需角色
            String needRole = configAttribute.getAttribute();
            //判断角色是否登录为可访问角色，此角色在CustomFilter中设置
            if("ROLE_LOGIN".equals(needRole)){
                //判断是否登录
                if (authentication instanceof AnonymousAuthenticationToken){
                    throw new AccessDeniedException("尚未登录，请登录");
                }else{
                    return;
                }
            }
            //判断角色是否为所需角色
            Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
            for (GrantedAuthority authority:authorities){
                if(authority.getAuthority().equals(needRole)){
                    return;
                }
            }
        }
        throw new AccessDeniedException("权限不足，请联系管理员");
    }

    @Override
    public boolean supports(ConfigAttribute attribute) {
        return false;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }
}
