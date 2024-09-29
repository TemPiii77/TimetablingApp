package org.example.backend.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link org.example.backend.domain.TeacherPreferredTimeId}
 */
@Data
@NoArgsConstructor
public class TeacherPreferredTimeIdDto implements Serializable {
    String teacherId;
    Integer preferredTimeId;
}