package com.xxxx.flyserver.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xxxx.flyserver.mapper.EmployeeMapper;
import com.xxxx.flyserver.pojo.Employee;
import com.xxxx.flyserver.pojo.RespBean;
import com.xxxx.flyserver.service.IEmployeeService;
import com.xxxx.flyserver.util.RedisUtil;
import io.jsonwebtoken.lang.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author cxf
 * @since 2022-03-12
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements IEmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;
    @Autowired
    private RedisUtil redisUtil;

    @Override
    public List<Employee> getEmp() {
        List<Employee> emps = (List<Employee>) redisUtil.get("emp");
        if(Collections.isEmpty(emps)){
            emps = employeeMapper.getAllEmp();
            redisUtil.set("emp",emps);
        }
        return emps;
    }

    @Override
    public RespBean addEmp(Employee employee) {
        int i = employeeMapper.insert(employee);
        if(i>0){
            redisUtil.del("emp");
            return RespBean.success("添加成功！");
        }
        return RespBean.error("添加失败！");
    }

    @Override
    public RespBean updateEmp(Employee employee) {
        int i = employeeMapper.updateById(employee);
        if(i>0){
            redisUtil.del("emp");
            return RespBean.success("更新成功！");
        }
        return RespBean.error("更新失败！");
    }

    @Override
    public RespBean deleteEmp(Integer id) {
        int i = employeeMapper.deleteById(id);
        if(i>0){
            redisUtil.del("emp");
            return RespBean.success("删除成功！");
        }
        return RespBean.error("删除失败！");
    }


}
