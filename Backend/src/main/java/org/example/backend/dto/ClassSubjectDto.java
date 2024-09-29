package org.example.backend.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link org.example.backend.domain.ClassSubject}
 */
@Data
@NoArgsConstructor
public class ClassSubjectDto implements Serializable {
    ClassSubjectIdDto id;
    ClassDto classField;
    SubjectDto subject;
}