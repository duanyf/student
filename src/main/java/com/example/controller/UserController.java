package com.example.controller;

import com.example.entity.User;
import com.example.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("/getAllUser")
    public List<User> getAllUser(){
        return userService.getAllUser();
    }

    @RequestMapping("/getUserByPage/{pageNum}/{pageSize}")
    public PageInfo<User> getUserByPage(@PathVariable int pageNum, @PathVariable int pageSize){
        PageHelper.startPage(pageNum, pageSize);
        List<User> allUser = userService.getAllUser();
        PageInfo<User> userPageInfo = new PageInfo<>(allUser);
        return userPageInfo;
    }

    @RequestMapping("/addUser/{name}/{password}")
    public String addUser(@PathVariable String name, @PathVariable String password){
        User user = new User();
        user.setName(name);
        user.setPassword(password);
        userService.addUser(user);
        return "add";
    }

    @RequestMapping("/delUserById/{id}")
    public String delUserById(@PathVariable int id){
        userService.delUserById(id);
        return "delete";
    }

    @RequestMapping("/updateUserById/{id}/{name}/{password}")
    public String updateUserById(@PathVariable int id, @PathVariable String name, @PathVariable String password){
        userService.updateUser(id, name, password);
        return "update";
    }
}
