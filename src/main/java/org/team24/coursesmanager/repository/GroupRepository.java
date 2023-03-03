package org.team24.coursesmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.team24.coursesmanager.entity.Group;

public interface GroupRepository extends JpaRepository<Group, Integer> {
}
