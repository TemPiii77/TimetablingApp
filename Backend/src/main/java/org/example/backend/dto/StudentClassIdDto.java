package org.example.backend.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link org.example.backend.domain.StudentClassId}
 */
@Data
@NoArgsConstructor
public class StudentClassIdDto implements Serializable {
    String studentId;
    Integer classId;
}