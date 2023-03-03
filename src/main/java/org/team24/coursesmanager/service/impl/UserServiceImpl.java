package org.team24.coursesmanager.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.team24.coursesmanager.dto.UserDTO;
import org.team24.coursesmanager.entity.User;
import org.team24.coursesmanager.repository.UserRepository;
import org.team24.coursesmanager.service.UserService;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Transactional
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public List<UserDTO> getAllStudent() {
        List<User> users = userRepository.findRoleStudent();
        return users.stream().map((user) -> modelMapper.map(user, UserDTO.class))
                .collect(Collectors.toList());
    }
    @Override
    public List<UserDTO> getAllTeacher() {
        List<User> users = userRepository.findRoleTeacher();
        return users.stream().map((user) -> modelMapper.map(user, UserDTO.class))
                .collect(Collectors.toList());
    }
    public UserDTO findById(Long id) {
        Optional<User> userDTO = userRepository.findById(id);
        return  modelMapper.map(userDTO, UserDTO.class);
    }
    public void create(User user) {
        userRepository.save(user);
    }
    public boolean delete(Long id) {
        if (userRepository.findById(id).isEmpty()){
            return false;
        }
        userRepository.deleteById(id);
        return true;
    }
}
