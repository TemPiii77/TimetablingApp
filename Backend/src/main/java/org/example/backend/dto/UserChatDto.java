package org.example.backend.dto;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link org.example.backend.domain.UserChat}
 */
@Value
public class UserChatDto implements Serializable {
    UserChatIdDto id;
    UserDto user;
    ChatDto chat;
}