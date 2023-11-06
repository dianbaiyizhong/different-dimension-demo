package com.nntk.ddd.domain.repository;

import com.nntk.ddd.common.dto.CommonQueryDto;
import com.nntk.ddd.common.result.PageResult;
import com.nntk.ddd.domain.entity.UserBo;

public interface IUserRepository {

    UserBo queryById(int id);

    UserBo queryByUserName(String userName);

    void save(UserBo user);


    PageResult<UserBo> getUserList(CommonQueryDto commonQueryDto);


}
