package com.xxxx.flyserver.controller;


import com.xxxx.flyserver.pojo.Menu;
import com.xxxx.flyserver.pojo.RespBean;
import com.xxxx.flyserver.pojo.Role;
import com.xxxx.flyserver.service.IMenuService;
import com.xxxx.flyserver.service.IRoleService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * 角色信息 前端控制器
 * </p>
 *
 * @author cxf
 * @since 2022-02-21
 */
@RestController
@RequestMapping("/admin/role")
public class RoleController {

    @Autowired
    private IMenuService menuService;
    @Autowired
    private IRoleService roleService;

    @ApiOperation(value = "获取菜单列表")
    @GetMapping("/menus")
    public List<Menu> getAllMenus(){
        return roleService.getAllMenus();
    }

    @ApiOperation(value = "根据角色获取菜单")
    @GetMapping("/menu")
    public List<Menu> getMenuWithRole(Integer rid){
        return roleService.getMenuWithRole(rid);
    }

    @ApiOperation(value = "获取所有角色")
    @GetMapping("/")
    public List<Role> getAllRoles(){
        return roleService.list();
    }

    @ApiOperation("添加角色")
    @PostMapping("/")
    public RespBean addRole(Integer[] mids,Role role){
        return roleService.addRole(mids, role);
    }

    @ApiOperation("删除角色")
    @DeleteMapping("/{roleId}")
    public RespBean deleteRole(@PathVariable("roleId") Integer roleId){
        return roleService.deleteRole(roleId);
    }

    @ApiOperation(value = "批量删除角色")
    @DeleteMapping("/")
    public RespBean deleteRoles(Integer[] ids){
        if(roleService.removeByIds(Arrays.asList(ids))){
            return RespBean.success("删除成功");
        }
        return RespBean.error("删除失败");
    }

    @ApiOperation("更新角色")
    @PutMapping("/")
    public RespBean updateRole(Integer[] mids,Role role){
        return roleService.updateRole(mids,role);
    }

}
