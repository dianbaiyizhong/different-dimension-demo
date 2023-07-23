package com.nntk.ddd.common.exception;

import com.nntk.ddd.common.constant.BaseRestCode;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BusinessException extends RuntimeException  {

    private transient Object data;

    private String clientTip;

    private String message;

    private BaseRestCode restCode;

}
