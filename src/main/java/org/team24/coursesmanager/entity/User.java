package org.team24.coursesmanager.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstname;
    private String lastname;
    private String email;
    private String password;

    @Column(name = "grades_sum")
    private Float gradesSum;

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "user")
    private List<Token> tokens;

    @OneToMany
    @JoinColumn(name = "user_id")
    private List<StudentLog> logs;

    @ManyToMany
    @JoinTable(name = "absence")
    private List<Lesson> missedLessons;

    @OneToMany
    private List<StudentGrade> grades;

    @ManyToMany
    @JoinTable(name = "users_xref_groups")
    private List<Group> group;

    public boolean addLog(StudentLog studentLog) {
        return logs.add(studentLog);
    }
}
