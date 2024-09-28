package org.example.backend.repository;

import org.example.backend.domain.TeacherSubject;
import org.example.backend.domain.TeacherSubjectId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherSubjectRepository extends JpaRepository<TeacherSubject, TeacherSubjectId> {
}