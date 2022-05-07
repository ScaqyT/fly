package com.xxxx.flyserver.service;

import com.xxxx.flyserver.pojo.Customer;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xxxx.flyserver.pojo.RespBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 客户信息 服务类
 * </p>
 *
 * @author cxf
 * @since 2022-02-21
 */
public interface ICustomerService extends IService<Customer> {

    /**
     * 获取客户信息
     *
     * @param id
     * @return
     */
    List<Customer> getCustomer(Integer id);

}
