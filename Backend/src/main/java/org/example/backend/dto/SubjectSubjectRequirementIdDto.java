package org.example.backend.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link org.example.backend.domain.SubjectSubjectRequirementId}
 */
@Data
@NoArgsConstructor
public class SubjectSubjectRequirementIdDto implements Serializable {
    Integer subjectId;
    Integer subjectRequirementId;
}