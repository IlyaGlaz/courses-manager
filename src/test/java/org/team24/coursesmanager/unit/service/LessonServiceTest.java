package org.team24.coursesmanager.unit.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.team24.coursesmanager.dto.LessonDto;
import org.team24.coursesmanager.entity.Lesson;
import org.team24.coursesmanager.repository.LessonRepository;
import org.team24.coursesmanager.service.LessonService;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class LessonServiceTest {
    @Mock
    private LessonRepository lessonRepository;
    @Mock
    private ModelMapper modelMapper;
    @InjectMocks
    private LessonService lessonService;
    @Test
    void findAllLessonTest() {
        List <LessonDto> lessonDtoMapper = getLessonDtoMapper();

        Mockito.when(lessonRepository.findAll()).thenReturn(getLessonList());

        assertEquals(lessonDtoMapper, lessonService.findAll());
    }
    private List <Lesson> getLessonList(){
        List <Lesson> lessonList = new ArrayList<>();
        lessonList.add(getLesson());
        return lessonList;
    }
    private Lesson getLesson(){
        Lesson lesson = new Lesson();
        lesson.setId(1);
        lesson.setTitle("Lesson 2");
        lesson.setDescription("Text 2");
        return lesson;
    }
    List <LessonDto> getLessonDtoMapper(){
        return getLessonList().stream()
                .map(lesson -> modelMapper.map(lesson, LessonDto.class)).collect(Collectors.toList());
    }
}