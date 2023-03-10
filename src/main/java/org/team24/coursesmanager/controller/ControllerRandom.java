package org.team24.coursesmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.team24.coursesmanager.random.RandomUser;
import org.team24.coursesmanager.service.RandomService;
import java.util.List;

@RestController
@RequestMapping("api/v1/user")
public class ControllerRandom {
    @Autowired
    RandomService randomService;
    RandomUser randomUser = new RandomUser();
    @GetMapping("/randomGroup/{id}")
    public List<String> listGroup(@PathVariable("id") Long id){
        return randomUser.randomUser(randomService.listGroup(id));
    }
}
