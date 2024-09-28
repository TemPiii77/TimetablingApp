package org.example.backend.repository;

import org.example.backend.domain.ClassScene;
import org.example.backend.domain.ClassSceneId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassSceneRepository extends JpaRepository<ClassScene, ClassSceneId> {
}