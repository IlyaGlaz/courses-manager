package org.team24.coursesmanager.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
public class GroupDto {
    private int id;
    private String name;
    private Date beginDate;
    private Date endDate;
    private List<UserDto> users;
}
