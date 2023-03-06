package org.team24.coursesmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.team24.coursesmanager.entity.User;

import java.util.List;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value = "FROM User where role = 'STUDENT'")
    List<User> findRoleStudent();
    @Query(value = "FROM User where role = 'TEACHER'")
    List<User> findRoleTeacher();
    @Query(value = "FROM User where groups_id = :id")
    List<User> listGroup(Long id);
}
