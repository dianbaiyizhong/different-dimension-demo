package com.nntk.ddd.application.impl;

import com.nntk.ddd.application.UserService;
import com.nntk.ddd.application.constant.ApplicationRestCode;
import com.nntk.ddd.application.converter.UserConvertor;
import com.nntk.ddd.application.entity.vo.UserVo;
import com.nntk.ddd.application.entity.query.CommonQuery;
import com.nntk.ddd.common.dto.CommonQueryDto;
import com.nntk.ddd.common.exception.ExceptionFactory;
import com.nntk.ddd.common.result.PageResult;
import com.nntk.ddd.domain.MqService;
import com.nntk.ddd.domain.UserBusinessService;
import com.nntk.ddd.domain.entity.UserBO;
import com.nntk.ddd.domain.repository.IUserRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {


    @Resource
    private UserBusinessService userBusinessService;

    @Resource
    private MqService mqService;


    @Resource
    private IUserRepository userRepository;

    @Override
    public UserVo register(UserVo userVo) {


        // 1.查看用户名是否已经被注册过
        UserBO userDo = userRepository.queryByUserName(userVo.getUserName());
        if (!Objects.isNull(userDo)) {
            ExceptionFactory.createBusiness(ApplicationRestCode.ALREADY_EXIST, "已存在相同用户名");
        }


        // 2.检查用户信息合法性
        UserBO userBo = UserConvertor.INSTANCE.vo2Bo(userVo);
        userBusinessService.check(userBo);


        // 3.注册逻辑，例如送积分，活动等等，这个属于业务，应该分层
        userBusinessService.register(userBo);

        // 4.调用数据库存入
        userRepository.save(userBo);

        // 5.发送消息队列，例如让消费者去消费，进行各种推荐推送等等
        mqService.send(null);

        return userVo;
    }

    @Override
    public PageResult getUserList(CommonQuery commonQuery) {


        PageResult<UserBO> tUserPageResult = userRepository.getUserList(CommonQueryDto.builder()
                .page(commonQuery.getPage())
                .rows(commonQuery.getRows())
                .build());

        return new PageResult(tUserPageResult.getTotal(), tUserPageResult.getResult());


    }
}
