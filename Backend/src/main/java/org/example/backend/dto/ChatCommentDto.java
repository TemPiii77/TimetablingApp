package org.example.backend.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.io.Serializable;
import java.time.Instant;

/**
 * DTO for {@link org.example.backend.domain.ChatComment}
 */
@Data
@NoArgsConstructor
public class ChatCommentDto implements Serializable {
    Integer id;
    String content;
    Instant dateRecorded;
    UserDto user;
    ChatDto chat;
}