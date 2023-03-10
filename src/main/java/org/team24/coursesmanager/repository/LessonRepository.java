package org.team24.coursesmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.team24.coursesmanager.entity.Lesson;
import java.time.LocalDateTime;
@Repository
public interface LessonRepository extends JpaRepository<Lesson, Long> {
//    @Modifying
//    @Query(value = "INSERT INTO lessons (begin_time, description, title, group_id, homework_id) VALUES (':beginTime', ':description', ':title', :id, :id)", nativeQuery = true)
//    void saveLesson(@Param("beginTime") LocalDateTime beginTime, @Param("description") String description, @Param("title") String title,  @Param("id") int id);
//}
}