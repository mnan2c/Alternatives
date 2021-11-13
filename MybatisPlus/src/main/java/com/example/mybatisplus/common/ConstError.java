package com.example.mybatisplus.common;

import lombok.Getter;
import lombok.experimental.Accessors;

/**
 * @author mnzhang
 * @description
 * @date 2021/06/29
 */
@Getter
public enum ConstError {

    // 400
    ID_IS_REQUIRED(400001, "请输入ID"),
    UNSUPPORTED_OPERATION(400002, "不支持的操作"),
    INVALID_ENUM_VALUE(400003, "无效的枚举值"),
    INVALID_REQUEST_PARAMETER(400004, "无效的请求参数"),
    DATETIME_IS_ACROSS(400005, "时间参数与已存在的数据存在交叉"),
    FIELD_VALUE_DUPLICATED(400007, "字段值重复"),
    MIN_AND_MAX_VALUE_ALL_NULL(400010, "最大值和最小值至少有一个不应为空或0"),
    MAX_VALUE_SHOULD_BE_GREATER_THAN_MIN_VALUE(400011, "最大值应大于最小值"),
    FIELD_IS_REQUIRED(400014, "字段不应为空"),
    BAD_REQUEST(400017, "请求错误"),
    IS_REQUIRED(400019, "该字段必填"),

    // 404
    FILE_NOT_FOUND(404001, "文件没有找到"),
    ENTITY_NOT_EXISTED(404002, "实体不存在"),

    // 500
    FILE_UPLOAD_FAILED(500001, "文件上传失败"),
    SYSTEM_BUSY(500002, "系统繁忙.."),
    SQL_EXECUTE_FAILED(500003, "sql执行失败"),
    FAILED_TO_READ_FILE(500004, "读取文件失败"),
    FAILED_TO_CREATE_ENTITY(500005, "创建失败"),
    FACTORY_HAS_NOT_BEEN_CONFIGURED(500006, "工厂建模尚未配置"),

    ENDING(0, "");

    @Accessors(fluent = true)
    private final Integer code;

    @Accessors(fluent = true)
    private final String message;

    ConstError(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
