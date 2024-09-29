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
@Table(name = "subject_subject_requirement")
public class SubjectSubjectRequirement {
    @EmbeddedId
    private SubjectSubjectRequirementId id;

    @MapsId("subjectId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @ColumnDefault("nextval('subject_subject_requirement_subject_id_seq')")
    @JoinColumn(name = "subject_id", nullable = false)
    private Subject subject;

    @MapsId("subjectRequirementId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @ColumnDefault("nextval('subject_subject_requirement_subject_requirement_id_seq')")
    @JoinColumn(name = "subject_requirement_id", nullable = false)
    private SubjectRequirement subjectRequirement;

    public void setSubject(Subject subject) {
        this.subject = subject;
        this.subject.setId(subject.getId());
        this.subject.setName(subject.getName());
    }

    public void setSubjectRequirement(SubjectRequirement subjectRequirement) {
        this.subjectRequirement = subjectRequirement;
        this.subjectRequirement.setId(subjectRequirement.getId());
        this.subjectRequirement.setField(subjectRequirement.getField());
        this.subjectRequirement.setGrade(subjectRequirement.getGrade());
        this.subjectRequirement.setPeriod(subjectRequirement.getPeriod());
        this.subjectRequirement.setAdvanced(subjectRequirement.getAdvanced());
    }

}