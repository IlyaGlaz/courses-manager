package org.team24.coursesmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.team24.coursesmanager.dto.UserDTO;
import org.team24.coursesmanager.entity.User;
import org.team24.coursesmanager.service.UserService;
import java.util.List;
@RestController
@RequestMapping("/user")
public class ControllerCRUDUsers {
    @Autowired
    UserService userService;
    @GetMapping("/student")
    public List<UserDTO> getAllStudent() {
        return userService.getAllStudent();
    }
    @GetMapping("/teacher")
    public List<UserDTO> getAllTeacher() {
        return userService.getAllTeacher();
    }
    @GetMapping("/{id}")
    public UserDTO showUser(@PathVariable("id") Long id) {
        return userService.findById(id);
    }
    @PostMapping // принять объект (тело объекта) !!!!!!!!!!!!!!!!!!!!!!!
    public void createUser(User user) {
        userService.create(user);
    }
    @DeleteMapping("/delete/{id}")// удалить объект - в таблице "users" нарушение: ограничение внешнего ключа "log_users_id_fkey" таблицы "log", всё ещё есть ссылки в таблице "log"!!!!!!!!!!!!!!!!!!!!!!!
    public boolean deleteUser(@PathVariable("id") Long id) {
        return userService.delete(id);
    }
}
