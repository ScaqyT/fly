package com.xxxx.flyserver.mapper;

import com.xxxx.flyserver.pojo.MenuRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 菜单-角色关系 Mapper 接口
 * </p>
 *
 * @author cxf
 * @since 2022-02-21
 */
public interface MenuRoleMapper extends BaseMapper<MenuRole> {

    /**
     * 添加角色权限
     * @param roleId
     * @param mids
     * @return
     */
    Integer addMenusRole(@Param("mids") Integer[] mids, @Param("roleId") Integer roleId);
}
