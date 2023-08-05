package com.nntk.ddd.infra.impl;

import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.core.query.QueryWrapper;
import com.nntk.ddd.common.result.PageResult;
import com.nntk.ddd.infra.UserRepository;
import com.nntk.ddd.infra.dto.CommonQueryDto;
import com.nntk.ddd.infra.repository.entity.TUser;
import com.nntk.ddd.infra.repository.mapper.TUserMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @Resource
    private TUserMapper userMapper;


    @Override
    public TUser queryById(int id) {
        return userMapper.selectOneById(id);
    }

    @Override
    public TUser queryByUserName(String userName) {
        return userMapper.selectOneByQuery(QueryWrapper.create().where(TUser::getUsername).eq(userName));
    }

    @Override
    public void save(TUser user) {
        userMapper.insert(user);
    }

    @Override
    public PageResult<TUser> getUserList(CommonQueryDto commonQueryDto) {
        Page<TUser> pager = userMapper.paginate(commonQueryDto.getPage(), commonQueryDto.getRows(), QueryWrapper.create().where(TUser::getId).ge(0));
        return new PageResult<>(pager.getTotalRow(), pager.getRecords());
    }


}
