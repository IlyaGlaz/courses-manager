package org.team24.coursesmanager.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
public class StudentLogReadDto {
    private long id;
    private String text;
    private LocalDateTime publishingTime;
    private LocalDateTime editingTime;
}
