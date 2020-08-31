package com.example.demo.dao;

import com.example.demo.model.User;

import java.util.List;

public interface UserDao {
    //abstract methods - > consist of all methods in api
    List<User> get();
    User get(String email);
    void save(User user);

}
