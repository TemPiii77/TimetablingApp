package org.example.backend.dto;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link org.example.backend.domain.ClassSceneId}
 */
@Value
public class ClassSceneIdDto implements Serializable {
    Integer classId;
    Integer sceneId;
}