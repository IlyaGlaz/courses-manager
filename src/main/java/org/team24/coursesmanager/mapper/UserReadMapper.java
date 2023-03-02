package org.team24.coursesmanager.mapper;

import org.springframework.stereotype.Component;
import org.team24.coursesmanager.dto.UserReadDto;
import org.team24.coursesmanager.entity.User;

@Component
public class UserReadMapper implements Mapper<User, UserReadDto> {

    @Override
    public UserReadDto map(User object) {
        return new UserReadDto(
                object.getId(),
                object.getFirstname(),
                object.getLastname(),
                object.getEmail()
        );
    }
}
