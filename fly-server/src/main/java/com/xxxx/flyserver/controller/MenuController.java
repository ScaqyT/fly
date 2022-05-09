package com.xxxx.flyserver.controller;


import com.xxxx.flyserver.pojo.Menu;
import com.xxxx.flyserver.pojo.RespBean;
import com.xxxx.flyserver.service.IMenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 菜单信息 前端控制器
 * </p>
 *
 * @author cxf
 * @since 2022-02-21
 */
@RestController
@RequestMapping("/system/config")
public class MenuController {
    @Autowired
    private IMenuService menuService;

    @ApiOperation(value = "根据admin ID获取菜单")
    @GetMapping("/menu")
    public List<Menu> getMenuWithAdminId(){
        return menuService.getMenuWithAdminId();
    }

    @ApiOperation(value = "更新菜单")
    @PutMapping("/menu")
    public RespBean updateMenu(@RequestBody Menu menu){
        return menuService.updateMenu(menu);
    }

    @ApiOperation(value = "添加菜单")
    @PostMapping("/menu")
    public RespBean addMenu(@RequestBody Menu menu){
        return menuService.addMenu(menu);
    }

    @ApiOperation(value = "删除菜单")
    @PutMapping("/menu/{id}")
    public RespBean deleteMenu(@PathVariable("id") Integer id){
        return menuService.deleteMenu(id);
    }



}
