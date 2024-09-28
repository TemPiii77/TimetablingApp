package org.example.backend.dto;

import lombok.Value;

import java.io.Serializable;
import java.time.Instant;

/**
 * DTO for {@link org.example.backend.domain.SceneComment}
 */
@Value
public class SceneCommentDto implements Serializable {
    Integer id;
    String content;
    Instant dateRecorded;
    UserDto user;
    ScenePartDto scenePart;
}