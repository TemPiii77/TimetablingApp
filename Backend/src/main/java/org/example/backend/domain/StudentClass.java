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
@Table(name = "student_class")
public class StudentClass {
    @EmbeddedId
    private StudentClassId id;

    @MapsId("studentId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    @MapsId("classId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @ColumnDefault("nextval('student_class_class_id_seq')")
    @JoinColumn(name = "class_id", nullable = false)
    private Class classField;

    public void setStudent(Student student) {
        this.student = student;
        this.student.setId(student.getId());
    }

    public void setClass(Class classField) {
        this.classField = classField;
        this.classField.setId(classField.getId());
        this.classField.setYear(classField.getYear());
        this.classField.setGrade(classField.getGrade());
        this.classField.setGroup(classField.getGroup());
        this.classField.setField(classField.getField());
    }

}