package org.example.backend.dto;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link org.example.backend.domain.TeacherSubjectId}
 */
@Value
public class TeacherSubjectIdDto implements Serializable {
    String teacherId;
    Integer subjectId;
}