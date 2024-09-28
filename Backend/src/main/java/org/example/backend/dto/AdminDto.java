package org.example.backend.dto;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link org.example.backend.domain.Admin}
 */
@Value
public class AdminDto implements Serializable {
    String id;
    UserDto user;
}