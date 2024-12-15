package org.example.backend.repository;

import org.example.backend.domain.Absence;
import org.example.backend.domain.Scene;
import org.example.backend.dto.SceneDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.time.Year;
import java.util.List;

@Repository
public interface SceneRepository extends JpaRepository<Scene, Integer> {

    @Query("SELECT s FROM Scene s " +
            "JOIN ClassScene cs ON cs.scene.id = s.id " +
            "JOIN Class c ON cs.classField.id = c.id " +
            "WHERE s.name LIKE %:year% AND c IN (" +
            "   SELECT c FROM Class c " +
            "   JOIN StudentClass sc ON sc.classField.id = c.id " +
            "   JOIN Student s ON sc.student.id = s.id " +
            "   WHERE s.id = :userId)")
    List<Scene> findStudentsScenes(@Param("userId") String userId,
                                     @Param("year") Integer year);

    @Query("SELECT s FROM Scene s " +
            "JOIN TeacherScene ts ON ts.scene.id = s.id " +
            "JOIN Teacher t ON ts.teacher.id = t.id " +
            "WHERE s.name LIKE %:year% AND t.id = :userId")
    List<Scene> findTeachersScenes(@Param("userId") String userId,
                                     @Param("year") Integer year);

    @Query("SELECT s FROM Scene s " +
            "WHERE s.name LIKE %:year%")
    List<Scene> findAdminsScenes(@Param("year") Integer year);


}