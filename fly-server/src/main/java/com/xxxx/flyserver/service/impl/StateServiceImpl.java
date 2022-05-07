package com.xxxx.flyserver.service.impl;

import com.xxxx.flyserver.pojo.State;
import com.xxxx.flyserver.mapper.StateMapper;
import com.xxxx.flyserver.service.IStateService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 仓库和订单状态
 服务实现类
 * </p>
 *
 * @author cxf
 * @since 2022-02-21
 */
@Service
public class StateServiceImpl extends ServiceImpl<StateMapper, State> implements IStateService {

}
