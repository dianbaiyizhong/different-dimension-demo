package com.nntk.ddd.application.converter;

import com.nntk.ddd.application.entity.vo.UserVo;
import com.nntk.ddd.common.convertor.BaseConvertor;
import com.nntk.ddd.domain.entity.UserBO;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;



import java.util.List;


@Mapper
public abstract class UserConvertor extends BaseConvertor {
    public static final UserConvertor INSTANCE = Mappers.getMapper(UserConvertor.class);

//    public abstract UserBO do2Bo(TUser user);
//
//
//    @Mappings({
//            @Mapping(source = "username", target = "userName")
//    })
//    public abstract UserVo do2Vo(TUser user);



//    public abstract List<UserVo> do2Vo(List<TUser> list);


//    public abstract List<UserBO> do2Bo(List<TUser> list);


    public abstract UserBO vo2Bo(UserVo user);

//    public abstract TUser bo2Do(UserBO user);

//    public abstract List<TUser> bo2Do(List<UserBO> list);



}
