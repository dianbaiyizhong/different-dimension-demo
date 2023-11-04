package com.nntk.ddd.common.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CommonQueryDto {
    private Integer page;
    private Integer rows;
}
