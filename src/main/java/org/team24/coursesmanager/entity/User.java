package org.team24.coursesmanager.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstname;


    private String lastname;

    private String email;

    private LocalDate birthDate;

    private String city;

    private String password;

    private Float totalGrade;

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "user")
    private List<Log> logs = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "groups_id")
    private Group group;

    @OneToMany(mappedBy = "user")
    private List<Grade> grades = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Absence> absences = new ArrayList<>();
}
