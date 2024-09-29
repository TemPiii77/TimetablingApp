package org.example.backend.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link org.example.backend.domain.ClassSubjectId}
 */
@Data
@NoArgsConstructor
public class ClassSubjectIdDto implements Serializable {
    Integer classId;
    Integer subjectId;
}