package org.example.backend.dto;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link org.example.backend.domain.TeacherPreferredTimeId}
 */
@Value
public class TeacherPreferredTimeIdDto implements Serializable {
    String teacherId;
    Integer preferredTimeId;
}