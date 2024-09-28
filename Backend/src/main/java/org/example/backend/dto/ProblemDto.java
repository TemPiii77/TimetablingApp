package org.example.backend.dto;

import lombok.Value;

import java.io.Serializable;
import java.time.Instant;

/**
 * DTO for {@link org.example.backend.domain.Problem}
 */
@Value
public class ProblemDto implements Serializable {
    Integer id;
    String type;
    String comment;
    Instant dateRecorded;
    StudentDto student;
    TimeslotDto timeslot;
}