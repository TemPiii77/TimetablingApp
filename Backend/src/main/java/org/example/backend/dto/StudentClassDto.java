package org.example.backend.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link org.example.backend.domain.StudentClass}
 */
@Data
@NoArgsConstructor
public class StudentClassDto implements Serializable {
    StudentClassIdDto id;
    StudentDto student;
    ClassDto classField;
}