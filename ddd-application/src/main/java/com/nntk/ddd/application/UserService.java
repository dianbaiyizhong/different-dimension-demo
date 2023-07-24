package com.nntk.ddd.application;

import com.nntk.ddd.application.entity.UserVo;
import com.nntk.ddd.common.result.PageResult;

public interface UserService {

    public UserVo register(UserVo userVo);



    public PageResult getUserList();


}
