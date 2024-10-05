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
public class ClassSubjectId implements Serializable {
    private static final long serialVersionUID = 2149698053792230986L;
    @ColumnDefault("nextval('class_subject_class_id_seq')")
    @Column(name = "class_id", nullable = false)
    private Integer classId;

    @ColumnDefault("nextval('class_subject_subject_id_seq')")
    @Column(name = "subject_id", nullable = false)
    private Integer subjectId;

    public ClassSubjectId() {
    }

    public ClassSubjectId(Integer classId, Integer subjectId) {
        this.classId = classId;
        this.subjectId = subjectId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ClassSubjectId entity = (ClassSubjectId) o;
        return Objects.equals(this.classId, entity.classId) &&
                Objects.equals(this.subjectId, entity.subjectId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(classId, subjectId);
    }

}