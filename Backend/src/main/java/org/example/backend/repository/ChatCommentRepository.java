package org.example.backend.repository;

import org.example.backend.domain.Chat;
import org.example.backend.domain.ChatComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChatCommentRepository extends JpaRepository<ChatComment, Integer> {
    @Query("SELECT cc FROM ChatComment cc " +
            "WHERE cc.chat.id = :chatId")
    List<ChatComment> findUsersChatComments(@Param("chatId") Integer chatId);
}