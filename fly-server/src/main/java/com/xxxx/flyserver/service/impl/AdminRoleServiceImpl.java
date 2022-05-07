package com.xxxx.flyserver.service.impl;

import com.xxxx.flyserver.pojo.AdminRole;
import com.xxxx.flyserver.mapper.AdminRoleMapper;
import com.xxxx.flyserver.service.IAdminRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户-角色关系 服务实现类
 * </p>
 *
 * @author cxf
 * @since 2022-02-21
 */
@Service
public class AdminRoleServiceImpl extends ServiceImpl<AdminRoleMapper, AdminRole> implements IAdminRoleService {

}
