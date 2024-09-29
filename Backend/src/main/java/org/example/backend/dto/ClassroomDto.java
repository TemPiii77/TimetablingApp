package org.example.backend.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link org.example.backend.domain.Classroom}
 */
@Data
@NoArgsConstructor
public class ClassroomDto implements Serializable {
    Integer id;
    String name;
    String type;
    Boolean doubleSize;
}