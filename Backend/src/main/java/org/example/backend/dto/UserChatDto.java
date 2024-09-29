package org.example.backend.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link org.example.backend.domain.UserChat}
 */
@Data
@NoArgsConstructor
public class UserChatDto implements Serializable {
    UserChatIdDto id;
    UserDto user;
    ChatDto chat;
}