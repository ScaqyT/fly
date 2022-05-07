package com.xxxx.flyserver.controller;


import com.xxxx.flyserver.pojo.Menu;
import com.xxxx.flyserver.service.IMenuService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

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




}
