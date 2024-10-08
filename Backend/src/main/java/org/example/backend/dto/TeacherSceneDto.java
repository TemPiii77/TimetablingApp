package org.example.backend.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link org.example.backend.domain.TeacherScene}
 */
@Data
@NoArgsConstructor
public class TeacherSceneDto implements Serializable {
    TeacherSceneIdDto id;
    TeacherDto teacher;
    SceneDto scene;
}