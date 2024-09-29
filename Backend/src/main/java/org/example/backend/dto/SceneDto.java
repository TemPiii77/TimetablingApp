package org.example.backend.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link org.example.backend.domain.Scene}
 */
@Data
@NoArgsConstructor
public class SceneDto implements Serializable {
    Integer id;
    String name;
    SubjectDto subject;
}