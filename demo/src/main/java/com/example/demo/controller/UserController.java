package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin()
@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/user")
    public List<User> get() {
        return userService.get();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/user")
    public String save(@RequestBody User user) {
        userService.save(user);
        return "Data Added to the Database successfully !!";
    }

    @RequestMapping("/user/{id}")
    public User get(@PathVariable String email) {
        User userObject = userService.get(email);
        if(userObject == null) {
            throw new RuntimeException("User with the id " + email + " does not exist!");
        } else {
            return userObject;
        }
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/user/{id}")
    public String update(@RequestBody User employee) {
        userService.save(employee);
        return "Data Updated !!";
    }


}