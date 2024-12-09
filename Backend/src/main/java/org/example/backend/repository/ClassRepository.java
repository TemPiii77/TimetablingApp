package org.example.backend.repository;

import org.example.backend.domain.Class;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassRepository extends JpaRepository<Class, Integer> {

    @Query("SELECT c FROM Class c " +
            "JOIN StudentClass sc ON sc.classField.id = c.id " +
            "JOIN Student s ON sc.student.id = s.id " +
            "WHERE s.id = :studentId")
    List<Class> findClassesByStudentId(@Param("studentId") String studentId);

}