package org.example.backend.repository;

import org.example.backend.domain.UserChat;
import org.example.backend.domain.UserChatId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserChatRepository extends JpaRepository<UserChat, UserChatId> {
}