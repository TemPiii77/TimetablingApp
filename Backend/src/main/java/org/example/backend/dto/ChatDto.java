package org.example.backend.dto;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link org.example.backend.domain.Chat}
 */
@Value
public class ChatDto implements Serializable {
    Integer id;
    String name;
}