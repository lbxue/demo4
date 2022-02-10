package com.example.demo.mapper;

import com.example.demo.pojo.Users;
import org.apache.catalina.User;

import java.util.List;

public interface UserMapper {

    public List<Users> selectUsers();

    public int addUser(Users user);

    public Users selectUserById(int id);

    public int updateUserById(Users user);

    public void deleteUserById(int id);
}
