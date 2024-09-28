package org.example.backend.dto;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link org.example.backend.domain.Scene}
 */
@Value
public class SceneDto implements Serializable {
    Integer id;
    String name;
    SubjectDto subject;
}