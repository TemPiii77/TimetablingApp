package org.example.backend.dto;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link org.example.backend.domain.StudentClass}
 */
@Value
public class StudentClassDto implements Serializable {
    StudentClassIdDto id;
    StudentDto student;
    ClassDto classField;
}