package org.example.backend.dto;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link org.example.backend.domain.ClassSubjectId}
 */
@Value
public class ClassSubjectIdDto implements Serializable {
    Integer classId;
    Integer subjectId;
}