package com.nntk.ddd.domain;

import com.nntk.ddd.domain.entity.UserBO;

public interface UserBusinessService {

    public UserBO register(UserBO userBo);

    public UserBO check(UserBO userBo);

}
