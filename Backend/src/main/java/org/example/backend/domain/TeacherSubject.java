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
@Table(name = "teacher_subject")
public class TeacherSubject {
    @EmbeddedId
    private TeacherSubjectId id;

    @MapsId("teacherId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "teacher_id", nullable = false)
    private Teacher teacher;

    @MapsId("subjectId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @ColumnDefault("nextval('teacher_subject_subject_id_seq')")
    @JoinColumn(name = "subject_id", nullable = false)
    private Subject subject;

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
}