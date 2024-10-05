package org.example.backend.repository;

import org.example.backend.domain.Class;
import org.example.backend.domain.StudentClass;
import org.example.backend.domain.StudentClassId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentClassRepository extends JpaRepository<StudentClass, StudentClassId> {
}