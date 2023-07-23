package com.nntk.ddd.domain.impl;

import com.nntk.ddd.domain.UserBusinessService;
import com.nntk.ddd.domain.entity.UserBo;
import org.springframework.stereotype.Service;

@Service
public class UserBusinessServiceImpl implements UserBusinessService {


    @Override
    public UserBo register(UserBo userBo) {

        // 1.查询当前是什么节日

        // 2.如果是儿童节，就赠送100积分


        return UserBo.builder()
                .points(10)
                .build();
    }

    @Override
    public UserBo check(UserBo userBo) {
        return null;
    }
}
