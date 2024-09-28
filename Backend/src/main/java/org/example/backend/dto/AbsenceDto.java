package org.example.backend.dto;

import lombok.Value;

import java.io.Serializable;
import java.time.Instant;

/**
 * DTO for {@link org.example.backend.domain.Absence}
 */
@Value
public class AbsenceDto implements Serializable {
    Integer id;
    String comment;
    Instant dateRecorded;
    StudentDto student;
    TimeslotDto timeslot;
}