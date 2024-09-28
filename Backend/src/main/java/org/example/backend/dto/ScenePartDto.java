package org.example.backend.dto;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link org.example.backend.domain.ScenePart}
 */
@Value
public class ScenePartDto implements Serializable {
    Integer id;
    String name;
    Boolean news;
    SceneDto scene;
}