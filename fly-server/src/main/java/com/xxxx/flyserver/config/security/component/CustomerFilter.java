package com.xxxx.flyserver.config.security.component;

import com.xxxx.flyserver.mapper.MenuMapper;
import com.xxxx.flyserver.pojo.Menu;
import com.xxxx.flyserver.pojo.Role;
import com.xxxx.flyserver.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import java.util.Collection;
import java.util.List;

/**
 * @program: fly
 * @description: 根据请求url获取菜单
 * @author: cxf
 * @create: 2022-02-28 15:28
 **/
@Component
public class CustomerFilter implements FilterInvocationSecurityMetadataSource {
    @Autowired
    private IMenuService menuService;

    AntPathMatcher antPathMatcher = new AntPathMatcher();

    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        //获取请求url
        String requestUrl = ((FilterInvocation) object).getRequestUrl();
        Integer rid = null;
        //获取菜单
        List<Menu> menus = menuService.getMenuWithRole(rid);
        for (Menu menu:menus){
            //判断请求url是否与菜单角色相匹配
            if(menu.getUrl()!=null) {
                if (antPathMatcher.match(menu.getUrl(), requestUrl)) {
                    String[] strings = menu.getRoles().stream().map(Role::getName).toArray(String[]::new);
                    return SecurityConfig.createList(strings);
                }
            }
        }
        //没匹配的url默认为登录即可访问
        return SecurityConfig.createList("ROLE_LOGIN");
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }
}
