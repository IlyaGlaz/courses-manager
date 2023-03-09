package org.team24.coursesmanager.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class UserDto {
    int id;
    String firstname;
    String lastname;
    String email;
    Float gradesSum;
    String role;
}
