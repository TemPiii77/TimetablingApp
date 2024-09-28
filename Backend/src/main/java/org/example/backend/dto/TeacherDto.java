package org.example.backend.dto;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link org.example.backend.domain.Teacher}
 */
@Value
public class TeacherDto implements Serializable {
    String id;
    UserDto user;
    String jobTitle;
}