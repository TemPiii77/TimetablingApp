package org.example.backend.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link org.example.backend.domain.UserChatId}
 */
@Data
@NoArgsConstructor
public class UserChatIdDto implements Serializable {
    String userId;
    Integer chatId;
}