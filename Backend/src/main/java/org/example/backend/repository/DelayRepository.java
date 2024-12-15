package org.example.backend.repository;

import org.example.backend.domain.Absence;
import org.example.backend.domain.Delay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;

@Repository
public interface DelayRepository extends JpaRepository<Delay, Integer> {

    @Query("SELECT d FROM Delay d WHERE d.student.id = :studentId AND d.dateRecorded BETWEEN :minYear AND :maxYear")
    List<Delay> findDelaysByYear(@Param("studentId") String studentId,
                                     @Param("minYear") Instant minYear,
                                     @Param("maxYear") Instant maxYear);
}