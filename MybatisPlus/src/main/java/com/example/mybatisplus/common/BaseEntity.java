package com.example.mybatisplus.common;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;

/**
 * @author mnzhang
 * @description
 * @date 2021/06/29
 */
@Data
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;

    private Long createDate;

    private Long createBy;

    private Long updateDate;

    private Long updateBy;
}
