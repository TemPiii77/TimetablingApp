package org.example.backend.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link org.example.backend.domain.TeacherPreferredTime}
 */
@Data
@NoArgsConstructor
public class TeacherPreferredTimeDto implements Serializable {
    TeacherPreferredTimeIdDto id;
    TeacherDto teacher;
    PreferredTimeDto preferredTime;
}