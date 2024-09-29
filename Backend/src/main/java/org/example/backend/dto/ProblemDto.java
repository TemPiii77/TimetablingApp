package org.example.backend.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.io.Serializable;
import java.time.Instant;

/**
 * DTO for {@link org.example.backend.domain.Problem}
 */
@Data
@NoArgsConstructor
public class ProblemDto implements Serializable {
    Integer id;
    String type;
    String comment;
    Instant dateRecorded;
    StudentDto student;
    TimeslotDto timeslot;
}