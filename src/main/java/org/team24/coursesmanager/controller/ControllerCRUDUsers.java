package org.team24.coursesmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.team24.coursesmanager.entity.User;
import org.team24.coursesmanager.service.UserService;
import java.util.List;
@RestController
@RequestMapping("/user")
public class ControllerCRUDUsers {
    @Autowired
    UserService userService;
    @GetMapping("/student")
    public List<User> getAllStudent() {
        return userService.getAllStudent();
    }
    @GetMapping("/teacher")
    public List<User> getAllTeacher() {
        return userService.getAllTeacher();
    }
}
