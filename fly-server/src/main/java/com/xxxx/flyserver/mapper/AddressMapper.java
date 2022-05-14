package com.xxxx.flyserver.mapper;

import com.xxxx.flyserver.pojo.Address;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author cxf
 * @since 2022-04-04
 */
public interface AddressMapper extends BaseMapper<Address> {

    List<Address> getAddress();
}
