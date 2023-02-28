package org.team24.coursesmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.team24.coursesmanager.entity.User;
import java.util.List;
@Repository
public interface UserRepository extends JpaRepository <User, Long> {
    @Query(value = "SELECT * FROM users WHERE role = 'STUDENT'",
            nativeQuery = true)
    List<User> findRoleStudent();

    @Query(value = "SELECT * FROM users WHERE role = 'TEACHER'",
            nativeQuery = true)
    List<User> findRoleTeacher();
}
