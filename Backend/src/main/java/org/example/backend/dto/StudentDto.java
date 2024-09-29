package org.example.backend.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link org.example.backend.domain.Student}
 */
@Data
@NoArgsConstructor
public class StudentDto implements Serializable {
    String id;
    UserDto user;
}