package org.team24.coursesmanager.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class ResourceErrorDto {
    private String message;
    private long timestamp;
}
