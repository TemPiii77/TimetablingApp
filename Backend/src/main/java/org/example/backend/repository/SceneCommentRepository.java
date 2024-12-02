package org.example.backend.repository;

import org.example.backend.domain.ChatComment;
import org.example.backend.domain.SceneComment;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SceneCommentRepository extends JpaRepository<SceneComment, Integer> {
    List<SceneComment> findByScenePartIdOrderByDateRecordedDesc(Integer scenePartId);
}