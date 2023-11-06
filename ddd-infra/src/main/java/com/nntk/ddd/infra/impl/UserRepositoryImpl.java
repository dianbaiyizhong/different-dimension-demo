package com.nntk.ddd.infra.impl;

import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.core.query.QueryWrapper;
import com.nntk.ddd.common.dto.CommonQueryDto;
import com.nntk.ddd.common.result.PageResult;
import com.nntk.ddd.domain.entity.UserBo;
import com.nntk.ddd.domain.repository.IUserRepository;
import com.nntk.ddd.infra.converter.UserConvertor;
import com.nntk.ddd.infra.repository.entity.TUser;
import com.nntk.ddd.infra.repository.mapper.TUserMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryImpl implements IUserRepository {

    @Resource
    private TUserMapper userMapper;


    @Override
    public UserBo queryById(int id) {
        TUser tUser = userMapper.selectOneById(id);
        return UserConvertor.INSTANCE.po2Bo(tUser);
    }

    @Override
    public UserBo queryByUserName(String userName) {
        TUser tUser = userMapper.selectOneByQuery(QueryWrapper.create().where(TUser::getUsername).eq(userName));
        return UserConvertor.INSTANCE.po2Bo(tUser);
    }

    @Override
    public void save(UserBo user) {
        TUser po = UserConvertor.INSTANCE.bo2Po(user);
        userMapper.insert(po);
    }


    @Override
    public PageResult<UserBo> getUserList(CommonQueryDto commonQueryDto) {
        Page<TUser> pager = userMapper.paginate(commonQueryDto.getPage(), commonQueryDto.getRows(), QueryWrapper.create().where(TUser::getId).ge(0));
        List<UserBo> userBos = UserConvertor.INSTANCE.po2Bo(pager.getRecords());
        return new PageResult<>(pager.getTotalRow(), userBos);
    }


}
