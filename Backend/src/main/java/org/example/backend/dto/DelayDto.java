package org.example.backend.dto;

import lombok.Value;

import java.io.Serializable;
import java.time.Instant;

/**
 * DTO for {@link org.example.backend.domain.Delay}
 */
@Value
public class DelayDto implements Serializable {
    Integer id;
    Short value;
    String comment;
    Instant dateRecorded;
    StudentDto student;
    TimeslotDto timeslot;
}