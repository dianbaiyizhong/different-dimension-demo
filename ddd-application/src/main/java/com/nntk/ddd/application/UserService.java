package com.nntk.ddd.application;

import com.nntk.ddd.application.entity.vo.UserVo;
import com.nntk.ddd.application.entity.query.CommonQuery;
import com.nntk.ddd.common.result.PageResult;

public interface UserService {

    public UserVo register(UserVo userVo);



    public PageResult getUserList(CommonQuery commonQuery);


}
