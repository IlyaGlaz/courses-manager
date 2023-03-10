package org.team24.coursesmanager.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.team24.coursesmanager.dto.UserWriteDto;
import org.team24.coursesmanager.entity.User;

@Component
@RequiredArgsConstructor
public class UserWriteMapper implements Mapper<UserWriteDto, User> {

    @Override
    public User map(UserWriteDto object) {
        User user = new User();
        user.setFirstname(object.getFirstname());
        user.setLastname(object.getLastname());
        user.setEmail(object.getEmail());
        user.setRole(object.getRole());
        user.setPassword(object.getPassword());

        return user;
    }
}
