package org.team24.coursesmanager.controller;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.team24.coursesmanager.dto.GroupDto;
import org.team24.coursesmanager.dto.UserDto;
import org.team24.coursesmanager.entity.Group;
import org.team24.coursesmanager.entity.User;
import org.team24.coursesmanager.service.GroupService;
import org.team24.coursesmanager.service.UserService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/test")
@AllArgsConstructor
public class TestController {
    private ModelMapper modelMapper;
    private UserService userService;
    private GroupService groupService;

    @GetMapping
    public String test() {
        return "test";
    }

    @GetMapping("/users")
    public List<UserDto> getAllUsers() {
        return userService.getAllUsers()
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/groups/{id}")
    public ResponseEntity<GroupDto> getGroupById(@PathVariable int id) {
        Group group = groupService.getById(id);
        if (group == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(convertToDto(group), HttpStatus.OK);
    }

    private UserDto convertToDto(User user) {
        return modelMapper.map(user, UserDto.class);
    }
    private GroupDto convertToDto(Group group) {
        return modelMapper.map(group, GroupDto.class);
    }
}
