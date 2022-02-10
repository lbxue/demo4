package com.example.demo.service;

import com.example.demo.pojo.Users;

import java.util.List;

public interface IUserService {

    public List<Users> selectUsers();

    public int addUser(Users user);

    public Users selectUserById(int id);

    public int updateUserById(Users user);

    public void deleteUserById(int id);
}
