package org.team24.coursesmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.team24.coursesmanager.entity.User;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value = "FROM User where role = 'STUDENT'")
    List<User> findRoleStudent();
    @Query(value = "FROM User where role = 'TEACHER'")
    List<User> findRoleTeacher();
    @Query(value = "select * from users inner join users_xref_groups on users.id = users_xref_groups.users_id where group_id = :id and role = 'STUDENT_ROLE'", nativeQuery = true)
    List<User> listGroup(Long id);
    Optional<User> findByEmail(String email);
}
