package org.example.backend.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link org.example.backend.domain.ScenePart}
 */
@Data
@NoArgsConstructor
public class ScenePartDto implements Serializable {
    Integer id;
    String name;
    Boolean news;
    SceneDto scene;
}