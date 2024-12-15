package org.example.backend.repository;

import org.example.backend.domain.Absence;
import org.example.backend.domain.Timeslot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;

@Repository
public interface TimeslotRepository extends JpaRepository<Timeslot, Integer> {
    @Query("SELECT t FROM Timeslot t " +
            "WHERE t.year = :year AND t.classField IN (" +
            "   SELECT c FROM Class c " +
            "   JOIN StudentClass sc ON sc.classField.id = c.id " +
            "   JOIN Student s ON sc.student.id = s.id " +
            "   WHERE s.id = :studentId)")
    List<Timeslot> findTimeslotsByYear(@Param("studentId") String studentId,
                                     @Param("year") Integer year);
}