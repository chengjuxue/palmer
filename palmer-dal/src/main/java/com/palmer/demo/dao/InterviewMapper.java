package com.palmer.demo.dao;

import com.palmer.demo.model.Interview;
import org.mybatis.spring.annotation.MapperScan;

@MapperScan
public interface InterviewMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Interview record);

    int insertSelective(Interview record);

    Interview selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Interview record);

    int updateByPrimaryKey(Interview record);
}