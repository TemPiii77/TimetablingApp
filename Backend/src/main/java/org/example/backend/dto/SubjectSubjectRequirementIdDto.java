package org.example.backend.dto;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link org.example.backend.domain.SubjectSubjectRequirementId}
 */
@Value
public class SubjectSubjectRequirementIdDto implements Serializable {
    Integer subjectId;
    Integer subjectRequirementId;
}