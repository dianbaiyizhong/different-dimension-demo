package com.nntk.ddd.infra;

import com.nntk.ddd.infra.repository.entity.TUser;

public interface UserRepository {

    TUser queryById(int id);

    TUser queryByUserName(String userName);

    void save(TUser user);

}
