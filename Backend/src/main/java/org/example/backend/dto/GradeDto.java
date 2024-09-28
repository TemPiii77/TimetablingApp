package org.example.backend.dto;

import lombok.Value;

import java.io.Serializable;
import java.time.Instant;

/**
 * DTO for {@link org.example.backend.domain.Grade}
 */
@Value
public class GradeDto implements Serializable {
    Integer id;
    Short value;
    String type;
    String comment;
    Instant dateRecorded;
    StudentDto student;
    TimeslotDto timeslot;
}