package org.example.backend.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link org.example.backend.domain.Class}
 */
@Data
@NoArgsConstructor
public class ClassDto implements Serializable {
    Integer id;
    Short year;
    Short grade;
    String group;
    String field;
}