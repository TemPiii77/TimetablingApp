package org.example.backend.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link org.example.backend.domain.Timeslot}
 */
@Data
@NoArgsConstructor
public class TimeslotDto implements Serializable {
    Integer id;
    Short year;
    String day;
    Short hour;
    ClassDto classField;
    TeacherDto teacher;
    SubjectDto subject;
    ClassroomDto classroom;
}