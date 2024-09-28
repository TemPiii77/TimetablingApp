package org.example.backend.dto;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link org.example.backend.domain.Student}
 */
@Value
public class StudentDto implements Serializable {
    String id;
    UserDto user;
}