package org.team24.coursesmanager.service;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.team24.coursesmanager.dto.LessonDto;
import org.team24.coursesmanager.entity.Lesson;
import org.team24.coursesmanager.repository.LessonRepository;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;
@Service
@Transactional
@RequiredArgsConstructor
public class LessonService {
    @Autowired
    private LessonRepository lessonRepository;
    @Autowired
    private ModelMapper modelMapper;
//    public void saveLesson(LessonDto lessonDto, int id){
//        Lesson lesson = modelMapper.map(lessonDto, Lesson.class);
//        lessonRepository.saveLesson(lesson.getBeginTime(), lesson.getDescription(), lesson.getTitle(), id);
//    }
    public List <LessonDto> findAll() {
        List <Lesson> lessonList = lessonRepository.findAll();
        return  lessonList.stream()
                .map(lesson -> modelMapper.map(lesson, LessonDto.class)).collect(Collectors.toList());
    }
}
