package org.example.backend.repository;

import org.example.backend.domain.Absence;
import org.example.backend.dto.AbsenceDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;

@Repository
public interface AbsenceRepository extends JpaRepository<Absence, Integer> {

    @Query("SELECT a FROM Absence a WHERE a.student.id = :studentId AND a.dateRecorded BETWEEN :minYear AND :maxYear")
    List<Absence> findAbsencesByYear(@Param("studentId") String studentId,
                                     @Param("minYear") Instant minYear,
                                     @Param("maxYear") Instant maxYear);
}