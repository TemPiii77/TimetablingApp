package org.example.backend.repository;

import org.example.backend.domain.Absence;
import org.example.backend.domain.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Integer> {
    @Query("SELECT s FROM Subject s " +
            "JOIN ClassSubject cs ON cs.subject.id = s.id " +
            "JOIN Class c ON cs.classField.id = c.id " +
            "WHERE c.id = :classId")
    List<Subject> findSubjectsByClassId(@Param("classId") Integer classId);
}