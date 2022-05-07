package com.xxxx.flyserver.service;

import com.xxxx.flyserver.pojo.Admin;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xxxx.flyserver.pojo.AdminLoginParam;
import com.xxxx.flyserver.pojo.RespBean;
import com.xxxx.flyserver.pojo.Role;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <p>
 * 用户信息 服务类
 * </p>
 *
 * @author cxf
 * @since 2022-02-21
 */
public interface IAdminService extends IService<Admin> {

    Admin getAdminByUsername(String username);

    RespBean login(AdminLoginParam adminLoginParam, HttpServletRequest request);

    RespBean logout();

    /**
     * 根据adminid获取角色
     * @param id
     * @return
     */
    List<Role> getRoles(Integer id);

    /**
     * 获取所有操作员
     * @param keyWords
     * @return
     */
    List<Admin> getAllAdmin(String keyWords);

    /**
     * 添加操作员
     * @param admin
     * @return
     */
//    RespBean addAdmin(Admin admin);

    /**
     * 添加操作员角色
     * @param adminId
     * @param rids
     * @return
     */
    RespBean addAdminRole(Integer adminId, Integer[] rids);

    RespBean addAdmin(Admin admin);
}
