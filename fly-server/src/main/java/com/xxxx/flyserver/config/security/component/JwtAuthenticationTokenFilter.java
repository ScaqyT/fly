package com.xxxx.flyserver.config.security.component;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xxxx.flyserver.pojo.Admin;
import com.xxxx.flyserver.util.JwtTokenUtil;
import com.xxxx.flyserver.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

/**
 * @program: fly
 * @description: jwt登录过滤器
 * @author: cxf
 * @create: 2022-02-24 21:03
 **/
@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    @Value("${jwt.tokenHeader}")
    private String tokenHeader;
    @Value("${jwt.tokenHead}")
    private String tokenHead;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private RedisUtil redisUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        //获取token
        String authToken = request.getHeader(tokenHeader);
        if (Objects.isNull(authToken) || !authToken.startsWith(tokenHead)) {
            filterChain.doFilter(request, response);
            return;
        }
        //解析token
        String adminId;
        try {
            String token = authToken.substring(tokenHead.length());
            adminId = jwtTokenUtil.getUserIdFormToken(token);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("token非法");
        }
        //从redis获取用户信息
        String redisKey = "login:" + adminId;
        JSONObject jsonObject = JSON.parseObject((String) redisUtil.get(redisKey));
        Admin admin = JSONObject.toJavaObject(jsonObject, Admin.class);

        //存入SecurityContextHolder中
        //获取权限信息到authenticationToken中
        if(Objects.isNull(admin)){
            throw new RuntimeException("用户未登录");
        }
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(admin,null,admin.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        filterChain.doFilter(request,response);
    }
}
