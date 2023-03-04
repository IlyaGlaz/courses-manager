package org.team24.coursesmanager.service;

import org.team24.coursesmanager.dto.UserDTO;
import org.team24.coursesmanager.entity.User;
import java.util.List;
public interface UserService {
    List<UserDTO> getAllStudent();
    List<UserDTO> getAllTeacher();
    UserDTO findById(Long id);
    void create(User user);
    boolean delete(Long id);
    List<User> listGroup(Long id);



    // MapStruct
    public List<UserDTO> getAllStudentMapStruct();
}
