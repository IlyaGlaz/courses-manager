package org.team24.coursesmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.team24.coursesmanager.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
