package com.xxxx.flyserver.service;

import com.xxxx.flyserver.pojo.Menu;
import com.xxxx.flyserver.pojo.RespBean;
import com.xxxx.flyserver.pojo.Role;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 角色信息 服务类
 * </p>
 *
 * @author cxf
 * @since 2022-02-21
 */
public interface IRoleService extends IService<Role> {

    /**
     * 添加角色信息
     * @param role
     * @param mids
     * @return
     */
    RespBean addRole(Integer[] mids,Role role );

    /**
     * 删除角色
     * @param roleId
     * @return
     */
    RespBean deleteRole(Integer roleId);

    /**
     * 更新角色
     * @param mids
     * @param role
     * @return
     */
    RespBean updateRole(Integer[] mids, Role role);

    /**
     * 获取所有角色信息
     * @return
     */
    List<Menu> getAllRoles();

    /**
     * 获取菜单列表
     * @return
     */
    List<Menu> getAllMenus();

    List<Menu> getMenuWithRole(Integer rid);
}
