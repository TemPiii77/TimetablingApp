package org.example.backend.dto;

import lombok.Value;

import java.io.Serializable;
import java.time.Instant;

/**
 * DTO for {@link org.example.backend.domain.ChatComment}
 */
@Value
public class ChatCommentDto implements Serializable {
    Integer id;
    String content;
    Instant dateRecorded;
    UserDto user;
    ChatDto chat;
}