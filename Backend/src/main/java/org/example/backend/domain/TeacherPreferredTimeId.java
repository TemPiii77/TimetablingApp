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
public class TeacherPreferredTimeId implements Serializable {
    private static final long serialVersionUID = 7055089509896255798L;
    @Column(name = "teacher_id", nullable = false, length = 6)
    private String teacherId;

    @ColumnDefault("nextval('teacher_preferred_time_preferred_time_id_seq')")
    @Column(name = "preferred_time_id", nullable = false)
    private Integer preferredTimeId;

    public TeacherPreferredTimeId() {
    }

    public TeacherPreferredTimeId(String teacherId, Integer preferredTimeId) {
        this.teacherId = teacherId;
        this.preferredTimeId = preferredTimeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        TeacherPreferredTimeId entity = (TeacherPreferredTimeId) o;
        return Objects.equals(this.preferredTimeId, entity.preferredTimeId) &&
                Objects.equals(this.teacherId, entity.teacherId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(preferredTimeId, teacherId);
    }

}