package com.nntk.ddd.web;

import com.nntk.ddd.application.UserService;
import com.nntk.ddd.application.entity.UserVo;
import com.nntk.ddd.common.result.RespBodyBuilder;
import com.nntk.ddd.common.result.ResultDataVo;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;


    @RequestMapping("/register")
    public ResultDataVo register(@RequestBody UserVo userVo) {
        userService.register(userVo);
        // 最简单的返回
        return RespBodyBuilder.success();

    }


    @RequestMapping("/register2")
    public ResultDataVo register2(@RequestBody UserVo userVo) {
        UserVo registeredUserVo = userService.register(userVo);
        // 什么？前端还要返回注册后的用户id，没关系
        return RespBodyBuilder.success(registeredUserVo);
    }











}
