package org.example.backend.dto;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link org.example.backend.domain.TeacherPreferredTime}
 */
@Value
public class TeacherPreferredTimeDto implements Serializable {
    TeacherPreferredTimeIdDto id;
    TeacherDto teacher;
    PreferredTimeDto preferredTime;
}