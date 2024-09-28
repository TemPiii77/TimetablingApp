package org.example.backend.dto;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link org.example.backend.domain.TeacherSceneId}
 */
@Value
public class TeacherSceneIdDto implements Serializable {
    String teacherId;
    Integer sceneId;
}