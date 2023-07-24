package com.nntk.ddd.common.result;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 此类专门为分页数据服务
 * @param <T>
 */
@Data
@NoArgsConstructor
public class PageResult<T> {
    private long total;


    private List<T> result;

    public PageResult(long total, List<T> result) {
        this.total = total;
        this.result = result;
    }


}
