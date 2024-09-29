package org.example.backend.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.io.Serializable;
import java.time.Instant;

/**
 * DTO for {@link org.example.backend.domain.Absence}
 */
@Data
@NoArgsConstructor
public class AbsenceDto implements Serializable {
    Integer id;
    String comment;
    Instant dateRecorded;
    StudentDto student;
    TimeslotDto timeslot;
}