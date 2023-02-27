package org.team24.coursesmanager.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.team24.coursesmanager.dao.UserDAO;
import org.team24.coursesmanager.entity.User;
import java.util.List;
@Repository
public class UserDAOImpl implements UserDAO {
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public List<User> getAllUser() {
        Session session = sessionFactory.openSession();
        List<User> userList = session.createQuery("from User", User.class).getResultList();
        session.close();
        return userList;
    }
    @Override
    public void createUser(User user) {
        Session session = sessionFactory.openSession();
        session.save(user);
        session.close();
    }
    @Override
    public User showUserId(Long id) {
        Session session = sessionFactory.openSession();
        User user = session.get(User.class,id);
        session.close();
        return user;
    }
}
