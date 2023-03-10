package org.team24.coursesmanager.service;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.team24.coursesmanager.dto.StudentLogReadDto;
import org.team24.coursesmanager.entity.StudentLog;
import org.team24.coursesmanager.entity.User;
import org.team24.coursesmanager.exception.ResourceNotFoundException;
import org.team24.coursesmanager.repository.StudentLogRepository;
import org.team24.coursesmanager.repository.UserRepository;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class StudentLogService {
    private final StudentLogRepository logRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public long addLog(long userId, String text) {
        User user = userRepository.findById(userId).orElseThrow(() ->
                new ResourceNotFoundException("User with id=" + userId + " not found"));

        StudentLog log = new StudentLog();
        log.setText(text);
        log.setPublishingTime(LocalDateTime.now());
        log.setUser(user);

        return logRepository.saveAndFlush(log).getId();
    }

    public List<StudentLogReadDto> getStudentLogs(long userId) {
        User user = userRepository.findById(userId).orElseThrow(() ->
                new ResourceNotFoundException("User with id=" + userId + " not found"));

        return user.getLogs()
                .stream()
                .map(entity -> modelMapper.map(entity, StudentLogReadDto.class))
                .collect(Collectors.toList());
    }

    public long editStudentLog(long userId, String editedText) {
        User user = userRepository.findById(userId).orElseThrow(() ->
                new ResourceNotFoundException("User with id=" + userId + " not found"));

        List<StudentLog> logs = user.getLogs();
        //Checking if the user has logs at all
        if (logs.size() == 0) throw new ResourceNotFoundException("User with id=" + userId + " doesn't have logs");

        StudentLog lastLog = logs.get(logs.size() - 1);
        //Checking if the user has a log of the last 24h
        if (Duration.between(lastLog.getPublishingTime(), LocalDateTime.now()).compareTo(Duration.ofHours(24)) >= 0)
            throw new ResourceNotFoundException("The user has no log of the last 24 hours");

        lastLog.setText(editedText);
        lastLog.setEditingTime(LocalDateTime.now());

        return lastLog.getId();
    }

    public boolean deleteStudentLog(long userId) {
        User user = userRepository.findById(userId).orElseThrow(() ->
                new ResourceNotFoundException("User with id=" + userId + " not found"));

        List<StudentLog> logs = user.getLogs();
        //Checking if the user has logs at all
        if (logs.size() == 0) throw new ResourceNotFoundException("User with id=" + userId + " doesn't have logs");

        StudentLog lastLog = logs.get(logs.size() - 1);
        //Checking if the user has a log of the last 24h
        if (Duration.between(lastLog.getPublishingTime(), LocalDateTime.now()).compareTo(Duration.ofHours(24)) >= 0)
            throw new ResourceNotFoundException("The user has no log of the last 24 hours");

        logRepository.delete(lastLog);

        return true;
    }
}
