package com.xxxx.flyserver.mapper;

import com.xxxx.flyserver.pojo.AdminRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 用户-角色关系 Mapper 接口
 * </p>
 *
 * @author cxf
 * @since 2022-02-21
 */
public interface AdminRoleMapper extends BaseMapper<AdminRole> {

    Integer addAdminRole(Integer adminId, Integer[] rids);
}
