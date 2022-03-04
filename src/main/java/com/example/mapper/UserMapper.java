package com.example.mapper;

import com.example.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    public List<User> getAllUser();

    public void addUser(User user);

    public void delUserById(int id);

    public void updateUserById(int id, String name, String password);
}
