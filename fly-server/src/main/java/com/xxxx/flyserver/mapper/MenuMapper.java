package com.xxxx.flyserver.mapper;

import com.xxxx.flyserver.pojo.Menu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 菜单信息 Mapper 接口
 * </p>
 *
 * @author cxf
 * @since 2022-02-21
 */
public interface MenuMapper extends BaseMapper<Menu> {

    List<Menu> getMenuWithRole(Integer rid);

    List<Menu> getMenuWithAdminId(Integer id);

    List<Menu> getAllMenus();
}
