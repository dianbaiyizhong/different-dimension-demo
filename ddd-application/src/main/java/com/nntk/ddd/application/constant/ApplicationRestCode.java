package com.nntk.ddd.application.constant;

import com.nntk.ddd.common.constant.BaseRestCode;

public class ApplicationRestCode extends BaseRestCode {

    public static final ApplicationRestCode ALREADY_EXIST = new ApplicationRestCode(409001, "重复资源", "已存在相同用户名");


    public ApplicationRestCode(int code, String message, String clientInfo) {
        super(code, message, clientInfo);
    }

    public ApplicationRestCode(int code, String message) {
        super(code, message);
    }

    public ApplicationRestCode(int code) {
        super(code);
    }
}
