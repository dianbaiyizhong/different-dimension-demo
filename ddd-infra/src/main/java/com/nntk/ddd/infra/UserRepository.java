package com.nntk.ddd.infra;

import com.nntk.ddd.common.result.PageResult;
import com.nntk.ddd.infra.dto.CommonQueryDto;
import com.nntk.ddd.infra.repository.entity.TUser;

public interface UserRepository {

    TUser queryById(int id);

    TUser queryByUserName(String userName);

    void save(TUser user);


    PageResult<TUser> getUserList(CommonQueryDto commonQueryDto);


}
