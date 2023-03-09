package org.team24.coursesmanager.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.team24.coursesmanager.entity.Role;

@Setter
@Getter
@NoArgsConstructor
public class UserWriteDto {
    String firstname;
    String lastname;
    String email;
    Role role;
    String password;
}
