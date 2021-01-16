package com.wfy.mapper;

import com.wfy.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {

    List<User> findUserAndRoles();

    void saveUser(User user);

    void updateUser(User user);

    void deleteUser(int id);

    User findUserById(int id);

    User findByName(String username,String password);

}
