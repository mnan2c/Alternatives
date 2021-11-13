package com.example.mybatisplus.common;

import lombok.Data;

/**
 * @author mnzhang
 * @description
 * @date 2021/06/29
 */
@Data
public abstract class BaseDto {

    private Long id;

    private String code;

    private Long createDate;

    private Long createBy;

    private Long updateDate;

    private Long updateBy;
}
