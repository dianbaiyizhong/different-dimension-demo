package com.nntk.ddd.common.exception;

import com.nntk.ddd.common.constant.BaseRestCode;

public class ExceptionFactory {

    public static void createBusiness(BaseRestCode restCode, String clientInfo) {
        throw BusinessException
                .builder()
                .restCode(restCode)
                .clientTip(clientInfo)
                .build();
    }

}
