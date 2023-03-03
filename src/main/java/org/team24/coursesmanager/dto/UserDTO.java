package org.team24.coursesmanager.dto;

import lombok.Data;
import org.team24.coursesmanager.entity.*;
import java.time.LocalDate;
@Data
public class UserDTO {
    String firstname;
    String lastname;
    String email;
    LocalDate birthDate;
    String city;
    String password;
    Float totalGrade;
    Role role;

    //List<Log> logs = new ArrayList<>();
    //Group group;
    //List<Grade> grades = new ArrayList<>();
    //List<Absence> absences = new ArrayList<>();
}
