package org.team24.coursesmanager.dto;

import lombok.Value;
import org.team24.coursesmanager.entity.Role;

import java.time.LocalDate;

@Value
public class UserWriteDto {

    String firstname;
    String lastname;
    LocalDate birthDate;
    String email;
    Role role;
    String password;
    String city;
}
