package com.wfy.controller;


import com.alibaba.fastjson.JSON;
import com.wfy.mapper.UserMapper;
import com.wfy.pojo.User;
import com.wfy.service.LoginLogService;
import com.wfy.service.UserService;
import com.wfy.utils.RedisUtil;
import com.wfy.utils.StringUtils;
import com.wfy.utils.ToolsUtil;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("/User")
public class UserController {

    @Resource
    private UserService userService;

    @Resource
    private LoginLogService loginLogService;

    @Resource
    private RedisUtil redisUtil;

    @Resource
    private UserMapper userMapper;

    @Resource
    private ToolsUtil toolsUtil;


    @RequestMapping("/findUserAndRoles")
    @ResponseBody
    public List<User> findUserAndRoles() {
        List<User> list = userService.findUserAndRoles();
        return list;
    }

    @RequestMapping("/saveUser")
    @ResponseBody
    public boolean saveUser(@RequestBody User user){
        String username = user.getUsername();
        int i = userService.checkUserName(username);
        if(i==1){
            return false;
        }
        userService.saveUser(user);
        return true;
    }

    @RequestMapping("/updateUser")
    @ResponseBody
    public boolean updateUser(@RequestBody User user){
        userService.updateUser(user);
        return true;
    }

    @RequestMapping("/deleteUser")
    @ResponseBody
    public void deleteUser(@RequestBody User user){
        userService.deleteUser(user.getId());
    }


    /**
     * @Author wfy
     * @Description: 用户登录
     * @param map,request
     * @return User
     * @Date 23:06 2021/01/30
     **/
    @RequestMapping("/login")
    @ResponseBody
    @Transactional
    public User login(@RequestBody Map<String, String> map, HttpServletRequest request) {
        String username = map.get("username");
        String password = map.get("password");
        User userMsg = userService.findByName(username, password);
        if (StringUtils.isNotNull(userMsg)) {
            if (username.equals(userMsg.getUsername())
                    && password.equals(userMsg.getPassword())) {
                //使用UUID生成token
                String token = UUID.randomUUID().toString();
                //存到redis，并设置20分钟过期时间
                redisUtil.set(token, JSON.toJSONString(userMsg),60*20);
                //记录登录日志
                Date now = new Date();
                SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
                SimpleDateFormat dateFormat2 = new SimpleDateFormat("HH:mm:ss");
                //获取登录用户的IP地址
                String ip = toolsUtil.getIpAddr(request);
                //获取角色代码对应的权限名
                String roleName = ToolsUtil.ROLE_MAP.get(userMsg.getRoleId());
                //获取登录设备信息
                String deviceInfo = toolsUtil.getDeviceInfo(request);
                Map<String, Object> logMap = new HashMap<>();
                logMap.put("username", username);
                logMap.put("roleId", userMsg.getRoleId());
                logMap.put("roleName", roleName);
                logMap.put("ip",ip);
                logMap.put("deviceInfo",deviceInfo);
                logMap.put("loginDate", dateFormat1.format(now));
                logMap.put("loginTime", dateFormat2.format(now));
                loginLogService.addLoginLog(logMap);
                userMsg.setToken(token);
                userMsg.setMsg("0");
                return userMsg;
            }
        }
        User user =new User();
        user.setMsg("1");
        return user;
    }

    @RequestMapping("/findUserById")
    @ResponseBody
    public User findUserById(@RequestBody User user) {
        User userById = userService.findUserById(user.getId());
        return userById;
    }

    @RequestMapping("/logout")
    @ResponseBody
    public boolean logout(@RequestBody User user) {
        String token = user.getToken();
        redisUtil.del(token);
        return true;
    }


    /**
     * @Author wfy
     * @Description: 分页查询用户
     * @param map
     * @return List<User>
     * @Date 20:41 2021/01/29
     **/
    @RequestMapping("/findUserByLimit")
    @ResponseBody
    public List<User> findByLimit(@RequestBody Map<String,Integer> map) {
        int limit = map.get("limit");
        if(limit<1){
            limit=0;
        }else{
            limit=(limit-1)*10;
        }
        List<User> result = userService.findByLimit(limit);
        return result;
    }

    /**
     * @Author wfy
     * @Description: 获取数据页数
     * @param
     * @return Map
     * @Date 16:27 2021/01/30
     **/
    @RequestMapping("/getUserPages")
    @ResponseBody
    public Map<String, Integer> getUserPages() {
        int userCount = userMapper.userCount();
        int pages = toolsUtil.dataPages(userCount);
        Map<String, Integer> map = new HashMap<>();
        map.put("pages", pages);
        map.put("userTotal", userCount);
        return map;
    }

    @RequestMapping("/checkUser")
    @ResponseBody
    public void checkUser() {

    }

}
