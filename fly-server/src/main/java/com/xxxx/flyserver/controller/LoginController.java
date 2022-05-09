package com.xxxx.flyserver.controller;

import com.xxxx.flyserver.pojo.Admin;
import com.xxxx.flyserver.pojo.AdminLoginParam;
import com.xxxx.flyserver.pojo.RespBean;
import com.xxxx.flyserver.service.IAdminService;
import com.xxxx.flyserver.util.RedisUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.List;

/**
 * @program: fly
 * @description: 登录控制器
 * @author: cxf
 * @create: 2022-02-24 10:26
 **/
@RestController
public class LoginController {
    @Autowired
    private IAdminService adminService;

    @ApiOperation(value = "返回当前用户信息")
    @GetMapping("/admin/info")
    public Admin getAdminInfo(Principal principal){
        if(principal==null){
            return null;
        }
        String username = principal.getName();
        Admin admin = adminService.getAdminByUsername(username);
        admin.setPassword(null);
        admin.setRoles(adminService.getRoles(admin.getId()));
        return admin;
    }

    @ApiOperation(value = "登录，之后返回token")
    @PostMapping("/login")
    public RespBean login(@RequestBody AdminLoginParam adminLoginParam, HttpServletRequest request){
        return adminService.login(adminLoginParam,request);
    }

    @ApiOperation(value = "登出")
    @GetMapping("/logout")
    public RespBean logout(){
        return adminService.logout();
    }
}
