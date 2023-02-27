package org.team24.coursesmanager.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.team24.coursesmanager.dao.UserDAO;
import org.team24.coursesmanager.entity.User;
import org.team24.coursesmanager.service.UserService;
import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDAO userDAO;
    @Override
    @Transactional
    public List<User> getAllUser() {
        return userDAO.getAllUser();
    }
    @Override
    @Transactional
    public User showUserId(Long id){
        return userDAO.showUserId(id);
    }
}
