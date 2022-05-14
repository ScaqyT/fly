package com.xxxx.flyserver.service.impl;

import com.xxxx.flyserver.pojo.Address;
import com.xxxx.flyserver.mapper.AddressMapper;
import com.xxxx.flyserver.service.IAddressService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author cxf
 * @since 2022-04-04
 */
@Service
public class AddressServiceImpl extends ServiceImpl<AddressMapper, Address> implements IAddressService {

    @Autowired
    private AddressMapper addressMapper;

    @Override
    public List<Address> getAddress() {
        return addressMapper.getAddress();
    }
}
