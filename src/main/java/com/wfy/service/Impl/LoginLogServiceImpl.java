package com.wfy.service.Impl;

import com.wfy.mapper.LoginLogMapper;
import com.wfy.service.LoginLogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class LoginLogServiceImpl implements LoginLogService {

    @Resource
    private LoginLogMapper loginLogMapper;

    @Override
    public void addLoginLog(Map<String,Object> map) {
        loginLogMapper.addLoginLog(map);
    }

    @Override
    public List<Map<String, Object>> findLogByLimit(int limit) {
        List<Map<String, Object>> list = loginLogMapper.queryLoginLogByLimit(limit);
        for (int i=0;i<list.size();i++){
            list.get(i).put("number", i+1);
        }
        return list;
    }


}
