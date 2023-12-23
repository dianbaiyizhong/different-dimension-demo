package com.nntk.ddd.domain.repository;

import com.nntk.ddd.common.dto.CommonQueryDto;
import com.nntk.ddd.common.result.PageResult;
import com.nntk.ddd.domain.entity.UserBO;

public interface IUserRepository {

    UserBO queryById(int id);

    UserBO queryByUserName(String userName);

    void save(UserBO user);


    PageResult<UserBO> getUserList(CommonQueryDto commonQueryDto);


}
