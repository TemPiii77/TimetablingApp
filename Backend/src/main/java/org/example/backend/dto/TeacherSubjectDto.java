package org.example.backend.dto;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link org.example.backend.domain.TeacherSubject}
 */
@Value
public class TeacherSubjectDto implements Serializable {
    TeacherSubjectIdDto id;
    TeacherDto teacher;
    SubjectDto subject;
}