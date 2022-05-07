package com.xxxx.flyserver.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xxxx.flyserver.mapper.EmployeeTypeMapper;
import com.xxxx.flyserver.pojo.EmployeeType;
import com.xxxx.flyserver.service.IEmployeeTypeService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author cxf
 * @since 2022-03-12
 */
@Service
public class EmployeeTypeServiceImpl extends ServiceImpl<EmployeeTypeMapper, EmployeeType> implements IEmployeeTypeService {

}
