package org.example.backend.repository;

import org.example.backend.domain.ClassSubject;
import org.example.backend.domain.ClassSubjectId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassSubjectRepository extends JpaRepository<ClassSubject, ClassSubjectId> {
}