package com.wfy.service.Impl;

import com.wfy.mapper.LoginLogMapper;
import com.wfy.service.LoginLogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

@Service
public class LoginLogServiceImpl implements LoginLogService {

    @Resource
    private LoginLogMapper loginLogMapper;

    @Override
    public void addLoginLog(Map<String,Object> map) {
        loginLogMapper.addLoginLog(map);
    }
}
