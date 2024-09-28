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
@Table(name = "class_subject")
public class ClassSubject {
    @EmbeddedId
    private ClassSubjectId id;

    @MapsId("classId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @ColumnDefault("nextval('class_subject_class_id_seq')")
    @JoinColumn(name = "class_id", nullable = false)
    private Class classField;

    @MapsId("subjectId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @ColumnDefault("nextval('class_subject_subject_id_seq')")
    @JoinColumn(name = "subject_id", nullable = false)
    private Subject subject;

}