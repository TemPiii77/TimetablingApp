package org.example.backend.dto;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link org.example.backend.domain.User}
 */
@Value
public class UserDto implements Serializable {
    String id;
    String email;
    String lastName;
    String firstName;
    String password;
    String role;
}