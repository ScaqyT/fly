package com.xxxx.flyserver.service;

import com.xxxx.flyserver.pojo.Menu;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xxxx.flyserver.pojo.RespBean;

import java.util.List;

/**
 * <p>
 * 菜单信息 服务类
 * </p>
 *
 * @author cxf
 * @since 2022-02-21
 */
public interface IMenuService extends IService<Menu> {

    /**
     * 根据角色获取菜单
     */
    List<Menu> getMenuWithRole(Integer rid);

    /**
     * 根据adminid获取菜单
     * @return
     */
    List<Menu> getMenuWithAdminId();

    /**
     * 获取所有菜单
     * @return
     */
    List<Menu> getAllMenus();

    RespBean updateMenu(Menu menu);

    RespBean addMenu(Menu menu);

    RespBean deleteMenu(Integer id);
}
