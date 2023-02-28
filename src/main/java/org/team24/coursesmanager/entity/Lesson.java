package org.team24.coursesmanager.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dateTime;

    private String subject;

    @OneToMany(mappedBy = "lesson")
    private List<Grade> grades = new ArrayList<>();

    @OneToMany(mappedBy = "lesson")
    private List<Absence> absences = new ArrayList<>();

    @OneToMany(mappedBy = "lesson")
    private List<Homework> homeworks = new ArrayList<>();
}
