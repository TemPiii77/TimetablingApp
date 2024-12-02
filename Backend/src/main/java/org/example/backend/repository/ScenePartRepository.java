package org.example.backend.repository;

import org.example.backend.domain.ScenePart;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScenePartRepository extends JpaRepository<ScenePart, Integer> {
    List<ScenePart> findBySceneId(Integer sceneId);
}