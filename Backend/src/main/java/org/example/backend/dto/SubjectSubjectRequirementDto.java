package org.example.backend.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link org.example.backend.domain.SubjectSubjectRequirement}
 */
@Data
@NoArgsConstructor
public class SubjectSubjectRequirementDto implements Serializable {
    SubjectSubjectRequirementIdDto id;
    SubjectDto subject;
    SubjectRequirementDto subjectRequirement;
}