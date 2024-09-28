package org.example.backend.dto;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link org.example.backend.domain.Classroom}
 */
@Value
public class ClassroomDto implements Serializable {
    Integer id;
    String name;
    String type;
    Boolean doubleSize;
}