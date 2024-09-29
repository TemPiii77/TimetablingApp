package org.example.backend.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link org.example.backend.domain.ClassSceneId}
 */
@Data
@NoArgsConstructor
public class ClassSceneIdDto implements Serializable {
    Integer classId;
    Integer sceneId;
}