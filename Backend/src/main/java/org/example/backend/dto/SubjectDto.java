package org.example.backend.dto;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link org.example.backend.domain.Subject}
 */
@Value
public class SubjectDto implements Serializable {
    Integer id;
    String name;
}