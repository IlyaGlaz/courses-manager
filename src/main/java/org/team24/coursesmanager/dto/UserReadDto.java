package org.team24.coursesmanager.dto;

import lombok.Value;
import org.team24.coursesmanager.entity.Role;

@Value
public class UserReadDto {

    long id;
    String firstname;
    String lastname;
    Role role;
}
