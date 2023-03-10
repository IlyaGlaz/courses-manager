package org.team24.coursesmanager.dto;


import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class AuthenticationDTO {

    @NotEmpty(message = "Поле не должно быть пустым")
    private String email;
    @NotEmpty(message = "Поле не должно быть пустым")
    private String password;
}
