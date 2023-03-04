package org.team24.coursesmanager.dto;

import lombok.Value;
import org.team24.coursesmanager.entity.Role;

@Value
public class UserWriteDto {

    String firstname;
    String lastname;
    String email;
    Role role;
    String password;
}
