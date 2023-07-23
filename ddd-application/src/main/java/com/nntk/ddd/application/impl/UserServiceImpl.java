package com.nntk.ddd.application.impl;

import com.nntk.ddd.application.UserService;
import com.nntk.ddd.application.entity.UserVo;
import com.nntk.ddd.domain.MqService;
import com.nntk.ddd.domain.UserBusinessService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {


    @Resource
    private UserBusinessService userBusinessService;

    @Resource
    private MqService mqService;

    @Override
    public void register(UserVo userVo) {


        // 1.查看用户名是否已经被注册过


        // 2.检查用户信息合法性


        // 3.注册逻辑，例如送积分，活动等等，这个属于业务，应该分层
        userBusinessService.register(null);

        // 4.调用数据库存入


        // 5.发送消息队列，例如让消费者去消费，进行各种推荐推送等等
        mqService.send(null);

    }
}
