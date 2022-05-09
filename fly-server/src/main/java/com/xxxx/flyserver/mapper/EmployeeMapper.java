package com.xxxx.flyserver.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xxxx.flyserver.pojo.Employee;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author cxf
 * @since 2022-03-12
 */
public interface EmployeeMapper extends BaseMapper<Employee> {

    List<Employee> getAllEmp();
}
