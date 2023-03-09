package org.team24.coursesmanager.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class GroupDto {
    int id;
    String name;
    Date beginDate;
    Date endDate;
    List<UserDto> users;
}
