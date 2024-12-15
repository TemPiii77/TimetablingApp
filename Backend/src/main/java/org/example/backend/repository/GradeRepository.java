package org.example.backend.repository;

import org.example.backend.domain.Delay;
import org.example.backend.domain.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;

@Repository
public interface GradeRepository extends JpaRepository<Grade, Integer> {

    @Query("SELECT g FROM Grade g " +
            "WHERE g.student.id = :studentId AND g.timeslot.classField.id = :classId AND g.timeslot.subject.id = :subjectId")
    List<Grade> findGradesByClassAndSubjectId(@Param("studentId") String studentId,
                                              @Param("classId") Integer classId,
                                              @Param("subjectId") Integer subjectId);
}