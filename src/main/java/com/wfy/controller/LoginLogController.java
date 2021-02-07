package com.wfy.controller;


import com.wfy.mapper.LoginLogMapper;
import com.wfy.service.LoginLogService;
import com.wfy.utils.ToolsUtil;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/loginLog")
public class LoginLogController {

    @Resource
    private LoginLogService loginLogService;

    @Resource
    private LoginLogMapper loginLogMapper;

    @Resource
    private ToolsUtil toolsUtil;

    /**
     * @param map
     * @return List<Map < String, Object>>
     * @Author wfy
     * @Description: 分页查询登录日志
     * @Date 22:26 2021/02/07
     **/
    @RequestMapping("/findLogByLimit")
    public List<Map<String, Object>> findLogByLimit(@RequestBody Map<String, Integer> map) {
        int limit = map.get("limit");
        if (limit < 1) {
            limit = 0;
        } else {
            limit = (limit - 1) * 10;
        }
        List<Map<String, Object>> logByLimit = loginLogService.findLogByLimit(limit);
        return logByLimit;
    }

    /**
     * @param
     * @return Map<String, Integer>
     * @Author wfy
     * @Description: 查询日志总数及分页后总页数
     * @Date 22:26 2021/02/07
     **/
    @RequestMapping("/getLogPages")
    public Map<String, Integer> getUserPages() {
        int logCount = loginLogMapper.loginLogCount();
        int pages = toolsUtil.dataPages(logCount);
        Map<String, Integer> map = new HashMap<>();
        map.put("pages", pages);
        map.put("logTotal", logCount);
        return map;
    }

    @RequestMapping("/deleteLog")
    public void deleteLog(@RequestBody Map<String, Integer> map) {
        loginLogMapper.deleteLog(map.get("logId"));
    }

}
