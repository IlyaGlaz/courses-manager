package org.team24.coursesmanager.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Student extends User {

    private Float totalGrade;

    @OneToMany(mappedBy = "student")
    private List<Log> logs = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "groups_id")
    private Group group;

    @OneToMany(mappedBy = "student")
    private List<Grade> grades = new ArrayList<>();

    @OneToMany(mappedBy = "student")
    private List<Absence> absences = new ArrayList<>();
}
