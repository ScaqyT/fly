package com.xxxx.flyserver.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xxxx.flyserver.mapper.AdminRoleMapper;
import com.xxxx.flyserver.mapper.RoleMapper;
import com.xxxx.flyserver.pojo.Admin;
import com.xxxx.flyserver.mapper.AdminMapper;
import com.xxxx.flyserver.pojo.AdminLoginParam;
import com.xxxx.flyserver.pojo.RespBean;
import com.xxxx.flyserver.pojo.Role;
import com.xxxx.flyserver.service.IAdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xxxx.flyserver.util.AdminUtils;
import com.xxxx.flyserver.util.JwtTokenUtil;
import com.xxxx.flyserver.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * 用户信息 服务实现类
 * </p>
 *
 * @author cxf
 * @since 2022-02-21
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements IAdminService {

    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private AdminRoleMapper adminRoleMapper;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private RedisUtil redisUtil;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @Override
    public Admin getAdminByUsername(String username) {
        LambdaQueryWrapper<Admin> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Admin::getUsername,username);
        Admin admin = adminMapper.selectOne(queryWrapper);
        return admin;

    }

    @Override
    public RespBean login(AdminLoginParam adminLoginParam, HttpServletRequest request) {
        String captcha = (String)request.getSession().getAttribute("captcha");
        String code = adminLoginParam.getCode();
        //判断验证码是否正确
        if(code == null || !captcha.equals(code)) {
            return RespBean.error("验证码错误，请重新输入");
        }
        //AuthenticationManager 进行用户认证
        UsernamePasswordAuthenticationToken authenticationToken=
                new UsernamePasswordAuthenticationToken(adminLoginParam.getUsername(),adminLoginParam.getPassword());
        Authentication authentication = authenticationManager.authenticate(authenticationToken);
        //如果认证没通过，给出对应的提示
        if(Objects.isNull(authentication)){
            return RespBean.error("用户名或密码错误");
        }
        //如果验证通过了，使用adminid生成token
        Admin admin = (Admin) authentication.getPrincipal();
        String adminId = admin.getId().toString();
        Object o = redisUtil.get("login:" + adminId);
        if(!Objects.isNull(o)){
            return RespBean.error("用户已登陆，请勿再次登陆");
        }
        String token = jwtTokenUtil.generateToken(adminId);
        Map<String,String> tokenMap = new HashMap<>();
        //将用户信息保存在redis缓存
        redisUtil.set("login:"+adminId, JSON.toJSONString(admin));
        redisUtil.expire("login:"+adminId,3600L);
        tokenMap.put("token",token);
        tokenMap.put("tokenHead",tokenHead);
        return RespBean.success("登陆成功",tokenMap);

    }

    @Override
    public RespBean logout() {
        //获取Security Context Holder中的userid
        Integer adminId = AdminUtils.getAdmin().getId();
//        UsernamePasswordAuthenticationToken authentication = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
//        Admin admin = (Admin) authentication.getPrincipal();
        //删除redis中的值
        redisUtil.del("login:"+adminId);
        return RespBean.success("注销成功");


    }

    @Override
    public List<Role> getRoles(Integer id) {
        return roleMapper.getRoles(id);
    }

    /**
     * 获取所有操作员
     * @param keyWords
     * @return
     */
    @Override
    public List<Admin> getAllAdmin(String keyWords) {
        List<Admin> allAdmin = adminMapper.getAllAdmin(AdminUtils.getAdmin().getId(), keyWords);
        return allAdmin;
    }

    /**
     * 添加操作员角色
     * @param adminId
     * @param rids
     * @return
     */
    @Override
    public RespBean addAdminRole(Integer adminId, Integer[] rids) {
        Integer result = adminRoleMapper.addAdminRole(adminId, rids);
        if(result!=0){
            return RespBean.success("添加成功");
        }
        return RespBean.error("添加失败");
    }

    @Override
    public RespBean addAdmin(Admin admin) {
        String s = passwordEncoder.encode(admin.getPassword());
        admin.setPassword(s);
        if(adminMapper.insert(admin)>0){
            return RespBean.success("添加成功");
        }
        return RespBean.error("添加失败");
    }

}
