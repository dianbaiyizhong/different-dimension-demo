package com.nntk.ddd.application.converter;

import com.nntk.ddd.application.entity.UserVo;
import com.nntk.ddd.common.convertor.BaseConvertor;
import com.nntk.ddd.domain.entity.UserBo;
import com.nntk.ddd.infra.repository.entity.TUser;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;


@Mapper
public abstract class UserConvertor extends BaseConvertor {
    public static final UserConvertor INSTANCE = Mappers.getMapper(UserConvertor.class);

    public abstract UserBo do2Bo(TUser user);

    public abstract List<UserBo> do2Bo(List<TUser> list);


    public abstract UserBo vo2Bo(UserVo user);

    public abstract TUser bo2Do(UserBo user);
    public abstract List<TUser> bo2Do(List<UserBo> list);




}
