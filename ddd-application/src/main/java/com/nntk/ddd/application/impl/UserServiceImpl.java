package com.nntk.ddd.application.impl;

import cn.hutool.core.util.ObjectUtil;
import com.nntk.ddd.application.UserService;
import com.nntk.ddd.application.constant.ApplicationRestCode;
import com.nntk.ddd.application.entity.UserVo;
import com.nntk.ddd.common.exception.BusinessException;
import com.nntk.ddd.domain.MqService;
import com.nntk.ddd.domain.UserBusinessService;
import com.nntk.ddd.application.converter.UserConvertor;
import com.nntk.ddd.domain.entity.UserBo;
import com.nntk.ddd.infra.UserRepository;
import com.nntk.ddd.infra.repository.entity.TUser;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {


    @Resource
    private UserBusinessService userBusinessService;

    @Resource
    private MqService mqService;


    @Resource
    private UserRepository userRepository;

    @Override
    public void register(UserVo userVo) {


        // 1.查看用户名是否已经被注册过
        TUser userDo = userRepository.queryByUserName(userVo.getUserName());
        if (ObjectUtil.isEmpty(userDo)) {
            throw BusinessException
                    .builder()
                    .restCode(ApplicationRestCode.ALREADY_EXIST)
                    .clientTip("已存在相同用户名")
                    .build();
        }


        // 2.检查用户信息合法性
        UserBo userBo = UserConvertor.INSTANCE.vo2Bo(userVo);
        userBusinessService.check(userBo);


        // 3.注册逻辑，例如送积分，活动等等，这个属于业务，应该分层
        userBusinessService.register(userBo);

        // 4.调用数据库存入
        userDo = UserConvertor.INSTANCE.bo2Do(userBo);
        userRepository.save(userDo);

        // 5.发送消息队列，例如让消费者去消费，进行各种推荐推送等等
        mqService.send(null);

    }
}
