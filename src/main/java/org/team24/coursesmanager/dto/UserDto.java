package org.team24.coursesmanager.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDto {
    private int id;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private Float gradesSum;
    private String role;
}
