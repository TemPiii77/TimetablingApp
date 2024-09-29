package org.example.backend.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.io.Serializable;
import java.time.Instant;

/**
 * DTO for {@link org.example.backend.domain.Delay}
 */
@Data
@NoArgsConstructor
public class DelayDto implements Serializable {
    Integer id;
    Short value;
    String comment;
    Instant dateRecorded;
    StudentDto student;
    TimeslotDto timeslot;
}