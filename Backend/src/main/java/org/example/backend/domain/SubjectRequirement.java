package org.example.backend.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@Entity
@Table(name = "subject_requirement")
public class SubjectRequirement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ColumnDefault("nextval('subject_requirement_id_seq')")
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "field", nullable = false, length = 300)
    private String field;

    @Column(name = "grade", nullable = false)
    private Short grade;

    @Column(name = "period", nullable = false)
    private Short period;

    @Column(name = "advanced", nullable = false)
    private Boolean advanced = false;

}