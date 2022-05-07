package com.xxxx.flyserver.config.Aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @program: fly
 * @description:
 * @author: cxf
 * @create: 2022-04-06 16:40
 **/
@Aspect
@Component
public class MyAOP {

    @Pointcut("execution(* com.xxxx.flyserver.controller.LoginController.*(..))")
    public void log(){}

    @Before("log()")
    public void dobefore(JoinPoint jp){
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        assert requestAttributes != null;
        HttpServletRequest request = requestAttributes.getRequest();
        System.out.println("前置通知===========》");
        System.out.println("URL："+request.getRequestURL().toString());
        System.out.println("HTTP_METHOD："+request.getMethod());
        System.out.println("CLASS_METHOD："+jp);
        System.out.println("ARGS："+ Arrays.toString(jp.getArgs()));
        System.out.println("===================");
    }

    @AfterReturning(returning = "ret",pointcut = "log()")
    public void doAfterReturning(Object ret){
        System.out.println("返回通知===========》");
        System.out.println("方法的返回值："+ret);
        System.out.println("===================");
    }

    @AfterThrowing(throwing = "ex", pointcut = "log()")
    public void doAfterThrowing(JoinPoint jp,Exception ex){
        System.out.println("异常通知===========》");
        System.out.println("产生异常的方法："+jp);
        System.out.println("异常种类："+ex);
        System.out.println("===================");
    }

    @After("log()")
    public void doAfter(JoinPoint jp){
        System.out.println("后置通知===========》");
        System.out.println("最后一定执行");
        System.out.println("===================");
    }
}
