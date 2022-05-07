package com.xxxx.flyserver.mapper;

import com.xxxx.flyserver.pojo.Customer;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 客户信息 Mapper 接口
 * </p>
 *
 * @author cxf
 * @since 2022-02-21
 */
public interface CustomerMapper extends BaseMapper<Customer> {

    /**
     * 获取用户信息
     *
     * @param id
     * @return
     */
    List<Customer> getCustomer(Integer id);
}
