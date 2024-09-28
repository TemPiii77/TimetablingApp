package org.example.backend.repository;

import org.example.backend.domain.SceneComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SceneCommentRepository extends JpaRepository<SceneComment, Integer> {
}