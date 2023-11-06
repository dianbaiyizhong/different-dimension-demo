package com.nntk.ddd.domain;

import com.nntk.ddd.domain.entity.UserBo;

public interface UserBusinessService {

    public UserBo register(UserBo userBo);

    public UserBo check(UserBo userBo);

}
