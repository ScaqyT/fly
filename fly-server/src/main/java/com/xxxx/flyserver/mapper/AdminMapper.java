package com.xxxx.flyserver.mapper;

import com.xxxx.flyserver.pojo.Admin;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 用户信息 Mapper 接口
 * </p>
 *
 * @author cxf
 * @since 2022-02-21
 */
public interface AdminMapper extends BaseMapper<Admin> {

    List<Admin> getAllAdmin(Integer id, String keyWords);
}
