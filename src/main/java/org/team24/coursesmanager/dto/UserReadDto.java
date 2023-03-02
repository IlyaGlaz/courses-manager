package org.team24.coursesmanager.dto;

import lombok.Value;

@Value
public class UserReadDto {

    Long id;
    String firstname;
    String lastname;
    String email;
}
