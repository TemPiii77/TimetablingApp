package org.example.backend.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link org.example.backend.domain.TeacherSubjectId}
 */
@Data
@NoArgsConstructor
public class TeacherSubjectIdDto implements Serializable {
    String teacherId;
    Integer subjectId;
}