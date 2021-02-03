package com.wfy.controller;


import com.alibaba.fastjson.JSON;
import com.wfy.mapper.UserMapper;
import com.wfy.pojo.User;
import com.wfy.service.UserService;
import com.wfy.utils.RedisUtil;
import com.wfy.utils.StringUtils;
import com.wfy.utils.ToolsUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/User")
public class UserController {

    @Resource
    private UserService userService;

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
     * @param map,session
     * @return User
     * @Date 23:06 2021/01/30
     **/
    @RequestMapping("/login")
    @ResponseBody
    public User login(@RequestBody Map<String, String> map, HttpSession session) {
        String username = map.get("username");
        String password = map.get("password");
        User userMsg = userService.findByName(username, password);
        System.out.println(userMsg);
        if (StringUtils.isNotNull(userMsg)) {
            if (username.equals(userMsg.getUsername())
                    && password.equals(userMsg.getPassword())) {
                Integer roleId = userMsg.getRoleId();
                session.setAttribute("roleId", roleId);
                //使用UUID生成token
                String token = UUID.randomUUID().toString();
                //存到redis，并设置20分钟过期时间
                redisUtil.set(token, JSON.toJSONString(userMsg),60*20);
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
        System.out.println(user.getId());
        User userById = userService.findUserById(user.getId());
        return userById;
    }

    @RequestMapping("/logout")
    @ResponseBody
    public boolean logout(@RequestBody User user,HttpSession session) {
        session.removeAttribute("roleId");
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
    public List<User> findByLimit(@RequestBody Map map) {
        System.out.println(map.get("limit"));
        int limit = (int) map.get("limit");
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

}
