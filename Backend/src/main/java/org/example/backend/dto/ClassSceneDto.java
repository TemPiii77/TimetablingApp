package org.example.backend.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link org.example.backend.domain.ClassScene}
 */
@Data
@NoArgsConstructor
public class ClassSceneDto implements Serializable {
    ClassSceneIdDto id;
    ClassDto classField;
    SceneDto scene;
}