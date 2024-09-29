package org.example.backend.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link org.example.backend.domain.TeacherSubject}
 */
@Data
@NoArgsConstructor
public class TeacherSubjectDto implements Serializable {
    TeacherSubjectIdDto id;
    TeacherDto teacher;
    SubjectDto subject;
}