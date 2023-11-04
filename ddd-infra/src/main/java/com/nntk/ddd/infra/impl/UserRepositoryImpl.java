package com.nntk.ddd.infra.impl;

import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.core.query.QueryWrapper;
import com.nntk.ddd.common.result.PageResult;
import com.nntk.ddd.domain.entity.UserBO;
import com.nntk.ddd.domain.repository.IUserRepository;
import com.nntk.ddd.common.dto.CommonQueryDto;
import com.nntk.ddd.infra.repository.entity.TUser;
import com.nntk.ddd.infra.repository.mapper.TUserMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements IUserRepository {

    @Resource
    private TUserMapper userMapper;


    @Override
    public UserBO queryById(int id) {
        userMapper.selectOneById(id);
        UserBO userBO = new UserBO();
        return userBO;
    }

    @Override
    public UserBO queryByUserName(String userName) {
        UserBO userBO = new UserBO();
        userMapper.selectOneByQuery(QueryWrapper.create().where(TUser::getUsername).eq(userName));
        return userBO;
    }

    @Override
    public void save(UserBO user) {

        TUser po = new TUser();
        userMapper.insert(po);

    }


    @Override
    public PageResult<UserBO> getUserList(CommonQueryDto commonQueryDto) {
        Page<TUser> pager = userMapper.paginate(commonQueryDto.getPage(), commonQueryDto.getRows(), QueryWrapper.create().where(TUser::getId).ge(0));
        return new PageResult<>(pager.getTotalRow(), null);
    }


}
