package com.xxxx.flyserver.config.security.component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xxxx.flyserver.pojo.RespBean;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @program: fly
 * @description: 未登录，返回自定义结果
 * @author: cxf
 * @create: 2022-02-25 23:50
 **/
@Component
public class RestAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        PrintWriter writer = response.getWriter();
        RespBean bean = RespBean.error("尚未登录，请登录");
        bean.setCode(401);
        writer.write(new ObjectMapper().writeValueAsString(bean));
        writer.flush();
        writer.close();
    }
}
