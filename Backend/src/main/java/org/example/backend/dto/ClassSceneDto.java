package org.example.backend.dto;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link org.example.backend.domain.ClassScene}
 */
@Value
public class ClassSceneDto implements Serializable {
    ClassSceneIdDto id;
    ClassDto classField;
    SceneDto scene;
}