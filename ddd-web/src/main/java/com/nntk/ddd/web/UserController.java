package com.nntk.ddd.web;

import com.nntk.ddd.application.UserService;
import com.nntk.ddd.application.entity.UserVo;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController("user")
public class UserController {

    @Resource
    private UserService userService;


    @RequestMapping("/register")
    public void register(@RequestBody UserVo userVo) {
        userService.register(userVo);
    }
}
