package org.example.backend.repository;

import org.example.backend.domain.TeacherScene;
import org.example.backend.domain.TeacherSceneId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherSceneRepository extends JpaRepository<TeacherScene, TeacherSceneId> {
}