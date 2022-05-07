package com.xxxx.flyserver.service.impl;

import com.xxxx.flyserver.pojo.Customer;
import com.xxxx.flyserver.mapper.CustomerMapper;
import com.xxxx.flyserver.pojo.RespBean;
import com.xxxx.flyserver.service.ICustomerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 客户信息 服务实现类
 * </p>
 *
 * @author cxf
 * @since 2022-02-21
 */
@Service
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, Customer> implements ICustomerService {

    @Autowired
    private CustomerMapper customerMapper;

    /**
     * 获取用户信息
     * @param id
     * @return
     */
    @Override
    public List<Customer> getCustomer(Integer id) {
        return customerMapper.getCustomer(id);
    }

}
