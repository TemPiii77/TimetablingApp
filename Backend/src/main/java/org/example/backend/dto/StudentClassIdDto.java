package org.example.backend.dto;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link org.example.backend.domain.StudentClassId}
 */
@Value
public class StudentClassIdDto implements Serializable {
    String studentId;
    Integer classId;
}