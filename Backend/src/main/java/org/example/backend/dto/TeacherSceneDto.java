package org.example.backend.dto;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link org.example.backend.domain.TeacherScene}
 */
@Value
public class TeacherSceneDto implements Serializable {
    TeacherSceneIdDto id;
    TeacherDto teacher;
    SceneDto scene;
}