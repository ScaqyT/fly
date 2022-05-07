package com.xxxx.flyserver.service.impl;

import com.xxxx.flyserver.pojo.Menu;
import com.xxxx.flyserver.mapper.MenuMapper;
import com.xxxx.flyserver.service.IMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xxxx.flyserver.util.AdminUtils;
import com.xxxx.flyserver.util.RedisUtil;
import io.jsonwebtoken.lang.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 菜单信息 服务实现类
 * </p>
 *
 * @author cxf
 * @since 2022-02-21
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements IMenuService {

    @Autowired
    private MenuMapper menuMapper;
    @Autowired
    private RedisUtil redisUtil;

    @Override
    public List<Menu> getMenuWithRole(Integer rid) {
        return menuMapper.getMenuWithRole(rid);
    }

    /**
     * 根据adminid获取menu
     * @return
     */
    @Override
    public List<Menu> getMenuWithAdminId() {
        Integer adminId = AdminUtils.getAdmin().getId();
        List<Menu> menus = (List<Menu>) redisUtil.get("menu_" + adminId);
        if(Collections.isEmpty(menus)){
            menus = menuMapper.getMenuWithAdminId(adminId);
            menus.get(0).setChildren(null);
            redisUtil.set("menu_"+adminId,menus);
        }
        return menus;
    }

    /**
     * 获取所有菜单
     * @return
     */
    @Override
    public List<Menu> getAllMenus() {
        return menuMapper.getAllMenus();
    }
}
