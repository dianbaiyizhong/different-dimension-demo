package com.nntk.ddd.application.entity.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserVo {


    private String userId;
    private String userName;
    private String password;
    private String sex;

}
