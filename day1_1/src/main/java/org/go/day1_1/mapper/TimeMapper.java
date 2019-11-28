package org.go.day1_1.mapper;

import org.apache.ibatis.annotations.Select;
/**
 * TimeMapper
 */
public interface TimeMapper {

    @Select("select now()")
    public String getTime();
}