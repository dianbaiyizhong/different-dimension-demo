package com.nntk.ddd.infra.impl;

import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.core.query.QueryWrapper;
import com.nntk.ddd.common.dto.CommonQueryDto;
import com.nntk.ddd.common.result.PageResult;
import com.nntk.ddd.domain.entity.UserBO;
import com.nntk.ddd.domain.repository.IUserRepository;
import com.nntk.ddd.infra.converter.UserConvertor;
import com.nntk.ddd.infra.repository.entity.TUserDO;
import com.nntk.ddd.infra.repository.mapper.TUserMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryImpl implements IUserRepository {

    @Resource
    private TUserMapper userMapper;


    @Override
    public UserBO queryById(int id) {
        TUserDO tUserDO = userMapper.selectOneById(id);
        return UserConvertor.INSTANCE.po2Bo(tUserDO);
    }

    @Override
    public UserBO queryByUserName(String userName) {
        TUserDO tUserDO = userMapper.selectOneByQuery(QueryWrapper.create().where(TUserDO::getUsername).eq(userName));
        return UserConvertor.INSTANCE.po2Bo(tUserDO);
    }

    @Override
    public void save(UserBO user) {
        TUserDO po = UserConvertor.INSTANCE.bo2Po(user);
        userMapper.insert(po);
    }


    @Override
    public PageResult<UserBO> getUserList(CommonQueryDto commonQueryDto) {
        Page<TUserDO> pager = userMapper.paginate(commonQueryDto.getPage(), commonQueryDto.getRows(), QueryWrapper.create().where(TUserDO::getId).ge(0));
        List<UserBO> userBos = UserConvertor.INSTANCE.po2Bo(pager.getRecords());
        return new PageResult<>(pager.getTotalRow(), userBos);
    }


}
