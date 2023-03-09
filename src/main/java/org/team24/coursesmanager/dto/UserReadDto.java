package org.team24.coursesmanager.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.team24.coursesmanager.entity.Role;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserReadDto {
    long id;
    String firstname;
    String lastname;
    Role role;
}
