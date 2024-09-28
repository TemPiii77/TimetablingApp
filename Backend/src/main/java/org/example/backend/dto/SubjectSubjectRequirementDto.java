package org.example.backend.dto;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link org.example.backend.domain.SubjectSubjectRequirement}
 */
@Value
public class SubjectSubjectRequirementDto implements Serializable {
    SubjectSubjectRequirementIdDto id;
    SubjectDto subject;
    SubjectRequirementDto subjectRequirement;
}