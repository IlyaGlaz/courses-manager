package org.team24.coursesmanager.controller;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.team24.coursesmanager.dto.GroupDto;
import org.team24.coursesmanager.dto.UserReadDto;
import org.team24.coursesmanager.entity.Group;
import org.team24.coursesmanager.entity.User;
import org.team24.coursesmanager.security.PersonDetails;
import org.team24.coursesmanager.service.GroupService;
import org.team24.coursesmanager.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/test")
@AllArgsConstructor
public class TestController {
    private final ModelMapper modelMapper;
    private final UserService userService;
    private final GroupService groupService;

    @GetMapping
    public String test() {
        return "test";
    }

    @GetMapping("/users")
    public List<UserReadDto> getAllUsers() {
        return userService.findAll();
    }

    @GetMapping("/groups/{id}")
    public ResponseEntity<GroupDto> getGroupById(@PathVariable int id) {
        Group group = groupService.getById(id);
        if (group == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(convertToDto(group), HttpStatus.OK);
    }

    private GroupDto convertToDto(Group group) {
        return modelMapper.map(group, GroupDto.class);
    }

    @GetMapping("/admin")
    public String adminPage() {
        return "admin";
    }

    @GetMapping("/showUserInfo")
    @ResponseBody
    public String showUserInfo() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        PersonDetails personDetails = (PersonDetails) authentication.getPrincipal();

        return personDetails.getUsername();
    }
}
