package com.xxxx.flyserver.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xxxx.flyserver.mapper.AdminRoleMapper;
import com.xxxx.flyserver.mapper.MenuMapper;
import com.xxxx.flyserver.mapper.MenuRoleMapper;
import com.xxxx.flyserver.pojo.*;
import com.xxxx.flyserver.mapper.RoleMapper;
import com.xxxx.flyserver.service.IAdminRoleService;
import com.xxxx.flyserver.service.IRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xxxx.flyserver.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 角色信息 服务实现类
 * </p>
 *
 * @author cxf
 * @since 2022-02-21
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

    @Autowired
    private MenuRoleMapper menuRoleMapper;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private MenuMapper menuMapper;
    @Autowired
    private AdminRoleMapper adminRoleMapper;
    @Autowired
    private RedisUtil redisUtil;

    /**
     * 添加角色信息
     * @param role
     * @param mids
     * @return
     */
    @Override
    public RespBean addRole(Integer[] mids,Role role) {
        role.setName("ROLE_"+role.getName());
        Integer insert = roleMapper.insert(role);
        Integer result = menuRoleMapper.addMenusRole(mids, role.getId());
        if(result == mids.length && insert == 1){
            return RespBean.success("添加成功");
        }
        return RespBean.error("添加失败");
    }

    /**
     * 删除角色
     * @param roleId
     * @return
     */
    @Override
    public RespBean deleteRole(Integer roleId) {
        int rid = menuRoleMapper.delete(new QueryWrapper<MenuRole>().eq("rid", roleId));
        int i = roleMapper.deleteById(roleId);
        if(rid!=0&&i!=0){
            List<AdminRole> ar = adminRoleMapper.selectList(new QueryWrapper<AdminRole>().eq("rid", roleId));
            for(AdminRole adminRole:ar){
                redisUtil.del("menu_"+adminRole.getAdminId());
            }
            return RespBean.success("删除成功");
        }
        return RespBean.error("删除失败");
    }

    /**
     * 更新角色信息
     * @param mids
     * @param role
     * @return
     */
    @Override
    public RespBean updateRole(Integer[] mids, Role role) {
        role.setName("ROLE_"+role.getName());
        menuRoleMapper.delete(new QueryWrapper<MenuRole>().eq("rid",role.getId()));
        roleMapper.updateById(role);
        Integer result = menuRoleMapper.addMenusRole(mids, role.getId());
        if(result == mids.length){
            //TODO
            List<AdminRole> ar = adminRoleMapper.selectList(new QueryWrapper<AdminRole>().eq("rid", role.getId()));
            for(AdminRole adminRole:ar){
                redisUtil.del("menu_"+adminRole.getAdminId());
            }
            return RespBean.success("更新成功");
        }
        return RespBean.error("更新失败");
    }

    /**
     * 获取所有角色信息
     * @return
     */
    @Override
    public List<Menu> getAllRoles() {
        return menuMapper.getMenuWithRole(null);
    }

    /**
     * 获取菜单列表
     * @return
     */
    @Override
    public List<Menu> getAllMenus() {
        return roleMapper.getAllMenus();
    }

    @Override
    public List<Menu> getMenuWithRole(Integer rid) {
        return roleMapper.getMenuWithRole(rid);
    }

}
