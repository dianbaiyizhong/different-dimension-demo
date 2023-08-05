package com.nntk.ddd.application.entity.query;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CommonQuery {
    @NotNull
    private Integer page;
    @NotNull
    private Integer rows;
}
