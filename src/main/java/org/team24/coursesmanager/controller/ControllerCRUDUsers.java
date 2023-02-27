package org.team24.coursesmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.team24.coursesmanager.entity.User;
import org.team24.coursesmanager.service.UserService;
import java.util.List;
@RequestMapping("/user")
@RestController
public class ControllerCRUDUsers {
    @Autowired
    UserService userService;

    @GetMapping
    public List<User> showUser() {
        System.out.println("This is controller" + userService.getAllUser());
        return userService.getAllUser();
    }
    @GetMapping("/user/{id}")
    public User showUserId(@PathVariable Long id){
        System.out.println("This is controller" + userService.showUserId(id));
        return userService.showUserId(id);
    }
//    @ResponseBody
//    @ExceptionHandler(HttpMediaTypeNotAcceptableException.class)
//    public String handleHttpMediaTypeNotAcceptableException() {
//        return "acceptable MIME type:" + MediaType.APPLICATION_JSON_VALUE;
//    }

}
