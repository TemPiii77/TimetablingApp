package org.example.backend.dto;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link org.example.backend.domain.ClassSubject}
 */
@Value
public class ClassSubjectDto implements Serializable {
    ClassSubjectIdDto id;
    ClassDto classField;
    SubjectDto subject;
}