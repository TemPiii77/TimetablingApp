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
@Table(name = "teacher_preferred_time")
public class TeacherPreferredTime {
    @EmbeddedId
    private TeacherPreferredTimeId id;

    @MapsId("teacherId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "teacher_id", nullable = false)
    private Teacher teacher;

    @MapsId("preferredTimeId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @ColumnDefault("nextval('teacher_preferred_time_preferred_time_id_seq')")
    @JoinColumn(name = "preferred_time_id", nullable = false)
    private PreferredTime preferredTime;

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
        this.teacher.setId(teacher.getId());
        this.teacher.setJobTitle(teacher.getJobTitle());
    }

    public void setPreferredTime(PreferredTime preferredTime) {
        this.preferredTime = preferredTime;
        this.preferredTime.setId(preferredTime.getId());
        this.preferredTime.setDay(preferredTime.getDay());
        this.preferredTime.setHour(preferredTime.getHour());
    }

}