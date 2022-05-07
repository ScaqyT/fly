package com.xxxx.flyserver.controller;


import com.xxxx.flyserver.pojo.Admin;
import com.xxxx.flyserver.pojo.RespBean;
import com.xxxx.flyserver.service.IAdminService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 用户信息 前端控制器
 * </p>
 *
 * @author cxf
 * @since 2022-02-21
 */
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private IAdminService adminService;

    @ApiOperation("获取操作员")
    @GetMapping("/")
    public List<Admin> getAllAdmin(String keyWords){
        return adminService.getAllAdmin(keyWords);
    }

    @ApiOperation("添加操作员")
    @PostMapping("/")
    public RespBean addAdmin(@RequestBody Admin admin){
        return adminService.addAdmin(admin);
    }

    @ApiOperation("删除操作员")
    @DeleteMapping("/{id}")
    public RespBean deleteAdmin(@PathVariable("id") Integer id){
        if(adminService.removeById(id)){
            return RespBean.success("删除成功");
        }
        return RespBean.error("删除失败");
    }

    @ApiOperation("添加操作员角色")
    @PostMapping("/role")
    public RespBean addAdminRole(Integer adminId,Integer[] rids){
        return adminService.addAdminRole(adminId,rids);
    }

}
