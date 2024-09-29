package org.example.backend.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link org.example.backend.domain.SubjectRequirement}
 */
@Data
@NoArgsConstructor
public class SubjectRequirementDto implements Serializable {
    Integer id;
    String field;
    Short grade;
    Short period;
    Boolean advanced;
}