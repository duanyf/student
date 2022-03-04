package com.example.service;

import com.example.entity.User;

import java.util.List;

public interface UserService {

    public List<User> getAllUser();
    public void addUser(User user);
    public void delUserById(int id);
    public void updateUser(int id, String name, String password);
}
