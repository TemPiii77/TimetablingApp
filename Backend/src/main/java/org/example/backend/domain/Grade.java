package org.example.backend.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "grade")
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ColumnDefault("nextval('grade_id_seq')")
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "value", nullable = false)
    private Short value;

    @Column(name = "type", nullable = false, length = 30)
    private String type;

    @Column(name = "comment", length = Integer.MAX_VALUE)
    private String comment;

    @Column(name = "date_recorded", nullable = false)
    private Instant dateRecorded;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    @Setter
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @ColumnDefault("nextval('grade_timeslot_id_seq')")
    @JoinColumn(name = "timeslot_id", nullable = false)
    private Timeslot timeslot;

    public void setStudent(Student student) {
        this.student = student;
        this.student.setId(student.getId());
        this.student.setUser(student.getUser());
    }
}