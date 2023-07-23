package com.nntk.ddd.infra.impl;

import com.nntk.ddd.infra.UserRepository;
import com.nntk.ddd.infra.repository.mapper.TUserMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @Resource
    private TUserMapper userMapper;


    @Override
    public void queryById(int id) {

        userMapper.deleteById(id);
    }
}
