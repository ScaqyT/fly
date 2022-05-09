package com.xxxx.flyserver.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xxxx.flyserver.pojo.Employee;
import com.xxxx.flyserver.pojo.RespBean;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author cxf
 * @since 2022-03-12
 */
public interface IEmployeeService extends IService<Employee> {

    List<Employee> getEmp();

    RespBean deleteEmp(Integer id);

    RespBean updateEmp(Employee employee);

    RespBean addEmp(Employee employee);
}
