package com.wfy.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface LoginLogMapper {

    void addLoginLog(Map<String,Object> map);

    List<Map<String,Object>> queryLoginLogByLimit(int limit);

    int loginLogCount();

    void deleteLog(int logId);

}
