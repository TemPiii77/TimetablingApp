package org.example.backend.dto;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link org.example.backend.domain.PreferredTime}
 */
@Value
public class PreferredTimeDto implements Serializable {
    Integer id;
    String day;
    Short hour;
}