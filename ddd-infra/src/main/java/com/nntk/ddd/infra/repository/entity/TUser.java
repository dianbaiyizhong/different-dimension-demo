package com.nntk.ddd.infra.repository.entity;

import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *  实体类。
 *
 * @author nntk
 * @since 2023-07-23
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(value = "t_user")
public class TUser implements Serializable {

    @Id(keyType = KeyType.Auto)
    private Integer id;

    private String username;

    private Integer sex;

}
