package org.team24.coursesmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.team24.coursesmanager.entity.StudentLog;

public interface StudentLogRepository extends JpaRepository<StudentLog, Long> {
}
