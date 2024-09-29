package org.example.backend.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link org.example.backend.domain.Teacher}
 */
@Data
@NoArgsConstructor
public class TeacherDto implements Serializable {
    String id;
    UserDto user;
    String jobTitle;
}