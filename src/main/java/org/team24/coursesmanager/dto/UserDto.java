package org.team24.coursesmanager.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.team24.coursesmanager.entity.Role;

@Data
@NoArgsConstructor
public class UserDto {

    private int id;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private float gradesSum;
    private String role;
}
