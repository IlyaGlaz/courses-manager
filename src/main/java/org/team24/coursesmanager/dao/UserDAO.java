package org.team24.coursesmanager.dao;

import org.team24.coursesmanager.entity.User;
import java.util.List;
public interface UserDAO {
    List<User> getAllStudent();
    List<User> getAllTeacher();
}
