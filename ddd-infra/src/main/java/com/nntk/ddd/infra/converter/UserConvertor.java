package com.nntk.ddd.infra.converter;

import com.nntk.ddd.common.convertor.BaseConvertor;
import com.nntk.ddd.domain.entity.UserBO;
import com.nntk.ddd.infra.repository.entity.TUserDO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;


@Mapper
public abstract class UserConvertor extends BaseConvertor {
    public static final UserConvertor INSTANCE = Mappers.getMapper(UserConvertor.class);


    @Mappings({
            @Mapping(source = "username", target = "username")
    })
    public abstract UserBO do2Bo(TUserDO user);

    public abstract List<UserBO> do2Bo(List<TUserDO> list);

    public abstract TUserDO bo2Do(UserBO user);



}
