package com.example.mybatisplus.common;

import java.time.ZoneId;

/**
 * @author mnzhang
 * @description
 * @date 2021/06/29
 */
public class Const {

    // date time format:
    public static final String DATE_FORMAT = "yyyy-MM-dd";
    public static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String DATE_TIME_FORMAT_T = "yyyy-MM-dd'T'HH:mm:ss";
    public static final String DATE_TIME_FORMAT_F = "yyyy-MM-dd HH:mm:ss'SSS";
    public static final String TIME_FORMAT = "HH:mm:ss";

    public static final String DATE_FORMAT_STRING = "yyyyMMdd";
    public static final String DATE_TIME_FORMAT_STRING = "yyyyMMddHHmmss";
    public static final String TIME_FORMAT_STRING = "HHmmss";

    public static final ZoneId defaultZone = ZoneId.of("UTC+8");

}
