package org.example.backend.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link org.example.backend.domain.PreferredTime}
 */
@Data
@NoArgsConstructor
public class PreferredTimeDto implements Serializable {
    Integer id;
    String day;
    Short hour;
}