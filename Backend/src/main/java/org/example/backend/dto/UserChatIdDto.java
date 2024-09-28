package org.example.backend.dto;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link org.example.backend.domain.UserChatId}
 */
@Value
public class UserChatIdDto implements Serializable {
    String userId;
    Integer chatId;
}