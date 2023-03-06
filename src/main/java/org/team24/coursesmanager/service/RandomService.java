package org.team24.coursesmanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.team24.coursesmanager.entity.User;
import org.team24.coursesmanager.repository.UserRepository;

import java.util.List;
@Transactional
@Service
public class RandomService {
    @Autowired
    private UserRepository userRepository;
    public List<User> listGroup(Long id) {
        return userRepository.listGroup(id);
    }
}
