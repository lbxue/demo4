package com.example.demo.service.imp;

import com.example.demo.mapper.UserMapper;
import com.example.demo.pojo.Users;
import com.example.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImp implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<Users> selectUsers() {
        return userMapper.selectUsers();
    }

    @Override
    public int addUser(Users user) {
        return userMapper.addUser(user);
    }

    @Override
    public Users selectUserById(int id) {
        return userMapper.selectUserById(id);
    }

    @Override
    public int updateUserById(Users user) {
        return userMapper.updateUserById(user);
    }

    @Override
    public void deleteUserById(int id) {
        userMapper.deleteUserById(id);
    }
}
