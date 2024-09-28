package org.example.backend.repository;

import org.example.backend.domain.ChatComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatCommentRepository extends JpaRepository<ChatComment, Integer> {
}