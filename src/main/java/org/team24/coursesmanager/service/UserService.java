package org.team24.coursesmanager.service;

import org.team24.coursesmanager.entity.User;
import java.util.List;
public interface UserService {
    List<User> getAllUser();

    User showUserId(Long id);
}
