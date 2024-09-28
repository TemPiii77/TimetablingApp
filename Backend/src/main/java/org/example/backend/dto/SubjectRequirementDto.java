package org.example.backend.dto;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link org.example.backend.domain.SubjectRequirement}
 */
@Value
public class SubjectRequirementDto implements Serializable {
    Integer id;
    String field;
    Short grade;
    Short period;
    Boolean advanced;
}