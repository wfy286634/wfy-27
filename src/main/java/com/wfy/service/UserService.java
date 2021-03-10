package com.wfy.service;

import com.wfy.pojo.User;

import java.util.List;

public interface UserService {

    void saveUser(User user);

    void updateUser(User user);

    void deleteUser(int id);

    List<User> findUserAndRoles();

    User findUserById(int id);

    User findByName(String username,String password);

    List<User> findByLimit(int limit);

    int checkUserName(String username);
}
