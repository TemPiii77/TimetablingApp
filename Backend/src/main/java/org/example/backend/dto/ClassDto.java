package org.example.backend.dto;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link org.example.backend.domain.Class}
 */
@Value
public class ClassDto implements Serializable {
    Integer id;
    Short year;
    Short grade;
    String group;
    String field;
}