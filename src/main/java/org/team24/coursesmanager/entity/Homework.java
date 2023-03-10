package org.team24.coursesmanager.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "homeworks")
public class Homework {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String text;

    @Column(name = "publishing_time")
    private LocalDateTime publishingTime;

    @Column(name = "editing_time")
    private LocalDateTime editingTime;

    @OneToMany(mappedBy = "homework")
    private List<Lesson> lessons;

    @OneToMany(mappedBy = "homework")
    private List<HomeworkReport> homeworkReports;
}
