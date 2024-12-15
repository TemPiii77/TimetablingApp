package org.example.backend.repository;

import org.example.backend.domain.Absence;
import org.example.backend.domain.Problem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;

@Repository
public interface ProblemRepository extends JpaRepository<Problem, Integer> {

    @Query("SELECT p FROM Problem p WHERE p.student.id = :studentId AND p.dateRecorded BETWEEN :minYear AND :maxYear")
    List<Problem> findProblemsByYear(@Param("studentId") String studentId,
                                     @Param("minYear") Instant minYear,
                                     @Param("maxYear") Instant maxYear);
}