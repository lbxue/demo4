package com.example.demo.controller;

import com.example.demo.pojo.Users;
import com.example.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping("/select")
    public ModelAndView selectUsers() {
        List<Users> usersList = userService.selectUsers();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("usersList", usersList);
        modelAndView.setViewName("showUsers");
        return modelAndView;
    }

    @RequestMapping("/addUserUi")
    public String addUserUi() {
        return "addUser";
    }

    @RequestMapping("/addUser")
    public String addUser(Users user) {
        //添加用户
        userService.addUser(user);
        user.getId();
        //回到用户展示页
        return "redirect:/users/select";
    }

    @RequestMapping("/modifyUserUi")
    public ModelAndView modifyUserUi(int id) {
        //根据用户id,查询用户信息
        Users user = userService.selectUserById(id);
        //将用户信息封装在ModelAndView中
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user", user);
        modelAndView.setViewName("modifyUser");
        return modelAndView;
    }

    @RequestMapping("/modifyUser")
    public String modifyUser(Users user) {
        //根据用户id，修改用户信息
        userService.updateUserById(user);
        //跳转到展示用户信息页
        return "redirect:/users/select";
    }

    @RequestMapping("/deleteUser")
    public String deleteUser(int id) {
        //根据用户id删除用户
        userService.deleteUserById(id);
        //跳转到用户信息展示页
        return "redirect:/users/select";
    }


}
