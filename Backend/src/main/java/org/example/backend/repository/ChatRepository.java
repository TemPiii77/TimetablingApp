package org.example.backend.repository;

import org.example.backend.domain.Chat;
import org.example.backend.domain.Delay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;

@Repository
public interface ChatRepository extends JpaRepository<Chat, Integer> {
    @Query("SELECT c FROM Chat c " +
            "JOIN UserChat uc ON uc.chat.id = c.id " +
            "JOIN User u ON uc.user.id = u.id " +
            "WHERE u.id = :userId")
    List<Chat> findUsersChats(@Param("userId") String userId);
}