package com.xxxx.flyserver.mapper;

import com.xxxx.flyserver.pojo.Menu;
import com.xxxx.flyserver.pojo.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 角色信息 Mapper 接口
 * </p>
 *
 * @author cxf
 * @since 2022-02-21
 */
public interface RoleMapper extends BaseMapper<Role> {

    List<Role> getRoles(Integer id);

    List<Menu> getAllMenus();
    List<Menu> getMenuWithRole(Integer rid);
}
