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
public class TeacherSubjectId implements Serializable {
    private static final long serialVersionUID = 3457275950914942947L;
    @Column(name = "teacher_id", nullable = false, length = 6)
    private String teacherId;

    @ColumnDefault("nextval('teacher_subject_subject_id_seq')")
    @Column(name = "subject_id", nullable = false)
    private Integer subjectId;

    public TeacherSubjectId() {
    }

    public TeacherSubjectId(String teacherId, Integer subjectId) {
        this.teacherId = teacherId;
        this.subjectId = subjectId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        TeacherSubjectId entity = (TeacherSubjectId) o;
        return Objects.equals(this.teacherId, entity.teacherId) &&
                Objects.equals(this.subjectId, entity.subjectId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(teacherId, subjectId);
    }

}