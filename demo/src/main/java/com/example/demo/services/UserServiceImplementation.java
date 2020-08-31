package com.example.demo.services;

import com.example.demo.dao.UserDao;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImplementation implements UserService {

    @Autowired
    UserDao userDAO;

    @Transactional
    @Override
    public List<User> get() {
        return userDAO.get();
    }

    @Transactional
    @Override
    public User get(String email) {
        return userDAO.get(email);
    }

    @Transactional
    @Override
    public void save(User user) {
        userDAO.save(user);
    }


}