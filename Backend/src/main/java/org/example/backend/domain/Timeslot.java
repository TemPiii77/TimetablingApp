package org.example.backend.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Getter
@Setter
@Entity
@Table(name = "timeslot")
public class Timeslot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ColumnDefault("nextval('timeslot_id_seq')")
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "year", nullable = false)
    private Short year;

    @Column(name = "day", nullable = false, length = 10)
    private String day;

    @Column(name = "hour", nullable = false)
    private Short hour;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.SET_NULL)
    @ColumnDefault("nextval('timeslot_class_id_seq')")
    @JoinColumn(name = "class_id", nullable = false)
    private Class classField;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.SET_NULL)
    @JoinColumn(name = "teacher_id", nullable = false)
    private Teacher teacher;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.SET_NULL)
    @ColumnDefault("nextval('timeslot_subject_id_seq')")
    @JoinColumn(name = "subject_id", nullable = false)
    private Subject subject;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.SET_NULL)
    @ColumnDefault("nextval('timeslot_classroom_id_seq')")
    @JoinColumn(name = "classroom_id", nullable = false)
    private Classroom classroom;

    public void setClass(Class classField) {
        this.classField = classField;
        this.classField.setId(classField.getId());
        this.classField.setYear(classField.getYear());
        this.classField.setGrade(classField.getGrade());
        this.classField.setGroup(classField.getGroup());
        this.classField.setField(classField.getField());
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
        this.teacher.setId(teacher.getId());
        this.teacher.setJobTitle(teacher.getJobTitle());
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
        this.subject.setId(subject.getId());
        this.subject.setName(subject.getName());
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
        this.classroom.setId(classroom.getId());
        this.classroom.setName(classroom.getName());
        this.classroom.setType(classroom.getType());
        this.classroom.setDoubleSize(classroom.getDoubleSize());
    }




}