package org.example.backend.repository;

import org.example.backend.domain.ScenePart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScenePartRepository extends JpaRepository<ScenePart, Integer> {
}