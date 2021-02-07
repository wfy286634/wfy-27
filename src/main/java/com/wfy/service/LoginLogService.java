package com.wfy.service;

import java.util.List;
import java.util.Map;

public interface LoginLogService {

    void addLoginLog(Map<String,Object> map);

    List<Map<String,Object>> findLogByLimit(int limit);

}
