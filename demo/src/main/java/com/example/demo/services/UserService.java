package com.example.demo.services;

import com.example.demo.model.User;
import java.util.* ;
public interface UserService {
    List<User> get();

    User get(String email);

    void save(User user);

}
