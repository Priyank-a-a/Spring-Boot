package com.example.demo.dao;

import com.example.demo.model.User;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

import java.util.List;

@Repository
public class UserDAOimplementation implements UserDao{
    @Autowired
    EntityManager entityManager;

    @Override
    public List<User> get() {
        // Functionality in the database
        Session currentSession = entityManager.unwrap(Session.class);
        Query<User> query = currentSession.createQuery("from User", User.class);
        List<User> list = query.getResultList();
        return list;
    }

    @Override
    public User get(String email) {
        Session currentSession = entityManager.unwrap((Session.class));
        User user = currentSession.get(User.class, email);
        return user;
    }

    @Override
    public void save(User user) {
        Session currentSession = entityManager.unwrap((Session.class));
        currentSession.saveOrUpdate(user);
    }
}


