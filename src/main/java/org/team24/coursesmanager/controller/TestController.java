package org.team24.coursesmanager.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.team24.coursesmanager.dto.UserDto;
import org.team24.coursesmanager.entity.User;
import org.team24.coursesmanager.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/test")
public class TestController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public String test() {
        return "test";
    }

    @GetMapping("/users")
    @ResponseBody
    public List<String> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(User::getEmail)
                .collect(Collectors.toList());
    }

    //@GetMapping("/users")
    //@ResponseBody
    //public List<UserDto> getAllUsers() {
    //    return userRepository.findAll()
    //            .stream().peek(System.out::println)
    //            .map(this::convertToDto).peek(System.out::println)
    //            .collect(Collectors.toList());
    //}

    //FIXME: При мапинге все lazy поля entity подгружаются. Почему и зачем.
    private UserDto convertToDto(User user) {
        return modelMapper.map(user, UserDto.class);
    }
}
