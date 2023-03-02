package org.team24.coursesmanager.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.team24.coursesmanager.entity.User;
import org.team24.coursesmanager.repository.UserRepository;
import org.team24.coursesmanager.service.UserService;
import java.util.List;
@Transactional
@Service
public class UserServiceImpl implements UserService {
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
