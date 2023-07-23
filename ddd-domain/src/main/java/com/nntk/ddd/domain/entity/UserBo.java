package com.nntk.ddd.domain.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserBo {

    // 积分
    private int points;
}
