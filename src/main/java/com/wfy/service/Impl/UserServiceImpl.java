package com.wfy.service.Impl;

import com.wfy.mapper.UserMapper;
import com.wfy.pojo.User;
import com.wfy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> findUserAndRoles() {
        List<User> userAndRoles = userMapper.findUserAndRoles();
        for (int i = 0; i < userAndRoles.size(); i++) {
            userAndRoles.get(i).setNumber(i+1);
        }

        return userAndRoles;
    }

    @Override
    public User findUserById(int id) {
        User userById = userMapper.findUserById(id);
        return userById;
    }

    @Override
    public User findByName(String username,String password) {
        User user = userMapper.findByName(username,password);
        if(user!=null){
            return user;
        }
         return null;
    }

    @Override
    public List<User> findByLimit(int limit) {
        List<User> userAndRoles = userMapper.findUserByLimit(limit);
        for (int i = 0; i < userAndRoles.size(); i++) {
            userAndRoles.get(i).setNumber(i+1);
        }
        return userAndRoles;
    }

    @Override
    public void saveUser(User user) {
        userMapper.saveUser(user);
    }

    @Override
    public void updateUser(User user) {
        userMapper.updateUser(user);
    }

    @Override
    public void deleteUser(int id) {
        userMapper.deleteUser(id);
    }

}
