package org.example.backend.repository;

import org.example.backend.domain.TeacherPreferredTime;
import org.example.backend.domain.TeacherPreferredTimeId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherPreferredTimeRepository extends JpaRepository<TeacherPreferredTime, TeacherPreferredTimeId> {
}