package com.wfy.controller;


import com.wfy.pojo.User;
import com.wfy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/User")
public class UserController {

    @Autowired
    private UserService userService;

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

    @RequestMapping("/login")
    @ResponseBody
    public User login(@RequestBody Map<String, String> map, HttpSession session) {
        String username = map.get("username");
        String password = map.get("password");
        User byName = userService.findByName(username, password);
        System.out.println(byName);
        if (byName.getUsername().equals(username)
                && byName.getPassword().equals(password)) {
            Integer roleId = byName.getRoleId();
            System.out.println(byName.getRolesList());
            session.setAttribute("roleId", roleId);
            return byName;

        } else {
            return null;
        }
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
    public boolean logout(HttpSession session) {
        session.removeAttribute("roleId");
        return true;
    }
}
