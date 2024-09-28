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
public class SubjectSubjectRequirementId implements Serializable {
    private static final long serialVersionUID = 5811037289705860777L;
    @ColumnDefault("nextval('subject_subject_requirement_subject_id_seq')")
    @Column(name = "subject_id", nullable = false)
    private Integer subjectId;

    @ColumnDefault("nextval('subject_subject_requirement_subject_requirement_id_seq')")
    @Column(name = "subject_requirement_id", nullable = false)
    private Integer subjectRequirementId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        SubjectSubjectRequirementId entity = (SubjectSubjectRequirementId) o;
        return Objects.equals(this.subjectRequirementId, entity.subjectRequirementId) &&
                Objects.equals(this.subjectId, entity.subjectId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subjectRequirementId, subjectId);
    }

}