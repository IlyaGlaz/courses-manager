package org.team24.coursesmanager.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class StudentLogReadDto {
    private long id;
    private LocalDateTime publishingTime;
    private LocalDateTime editingTime;
}
