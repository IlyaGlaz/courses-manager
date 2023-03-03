package org.team24.coursesmanager.dto;

import lombok.Value;
import org.team24.coursesmanager.entity.Role;

import java.time.LocalDate;

@Value
public class UserReadDto {

    String firstname;
    String lastname;
    LocalDate birthDate;
    Role role;
}
