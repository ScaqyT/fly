package com.xxxx.flyserver.service;

import com.xxxx.flyserver.pojo.Address;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author cxf
 * @since 2022-04-04
 */
public interface IAddressService extends IService<Address> {

    List<Address> getAddress();
}
