package org.team24.coursesmanager.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.team24.coursesmanager.dao.UserDAO;
import org.team24.coursesmanager.entity.User;
import org.team24.coursesmanager.repository.UserRepository;
import java.util.List;
@Repository
public class UserDAOImpl implements UserDAO {
    @Autowired
    UserRepository userRepository;
    @Override
    public List<User> getAllStudent() {
        return userRepository.findRoleStudent();
    }
    @Override
    public List<User> getAllTeacher() {
        return userRepository.findRoleTeacher();
    }
}
