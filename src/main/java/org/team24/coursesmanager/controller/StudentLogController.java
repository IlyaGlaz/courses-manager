package org.team24.coursesmanager.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.team24.coursesmanager.dto.StudentLogReadDto;
import org.team24.coursesmanager.service.StudentLogService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/logs")
@RequiredArgsConstructor
public class StudentLogController {
    private final StudentLogService logService;

    @PostMapping("/{userId}")
    public long addStudentLog(@PathVariable long userId, @RequestBody String logText) {
        return logService.addLog(userId, logText);
    }

    @GetMapping("/{userId}")
    public List<StudentLogReadDto> getStudentLogs(@PathVariable long userId) {
        return logService.getStudentLogs(userId);
    }

    @PutMapping("/{userId}")
    public long editStudentLog(@PathVariable long userId, @RequestBody String logText) {
        return logService.editStudentLog(userId, logText);
    }

    @DeleteMapping("/{userId}")
    public boolean deleteStudentLog(@PathVariable long userId) {
        return logService.deleteStudentLog(userId);
    }

}
