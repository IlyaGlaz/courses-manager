package org.team24.coursesmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.team24.coursesmanager.dto.LessonDto;
import org.team24.coursesmanager.service.LessonService;
import java.util.List;
@RestController
@RequestMapping("api/v1/user/lesson")
public class LessonController {
    @Autowired
    private LessonService lessonService;
//    @PostMapping("/{id}")
//    @ResponseStatus(HttpStatus.CREATED)
//    public void saveLesson(@RequestBody LessonDto lessonDto, @PathVariable int id){
//        lessonService.saveLesson(lessonDto, id);
//    }
    @GetMapping()
    public List<LessonDto> findByAllLesson(){
        return lessonService.findAll();
    }
}
