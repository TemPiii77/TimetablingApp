package org.example.backend.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;
import org.hibernate.annotations.ColumnDefault;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class StudentClassId implements Serializable {
    private static final long serialVersionUID = -4083825502351819436L;
    @Column(name = "student_id", nullable = false, length = 6)
    private String studentId;

    @ColumnDefault("nextval('student_class_class_id_seq')")
    @Column(name = "class_id", nullable = false)
    private Integer classId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        StudentClassId entity = (StudentClassId) o;
        return Objects.equals(this.studentId, entity.studentId) &&
                Objects.equals(this.classId, entity.classId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, classId);
    }

}