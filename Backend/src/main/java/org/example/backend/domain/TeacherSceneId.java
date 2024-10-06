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
public class TeacherSceneId implements Serializable {
    private static final long serialVersionUID = 3909635874637329494L;
    @Column(name = "teacher_id", nullable = false, length = 6)
    private String teacherId;

    @ColumnDefault("nextval('teacher_scene_scene_id_seq')")
    @Column(name = "scene_id", nullable = false)
    private Integer sceneId;

    public TeacherSceneId() {
    }

    public TeacherSceneId(String teacherId, Integer sceneId) {
        this.teacherId = teacherId;
        this.sceneId = sceneId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        TeacherSceneId entity = (TeacherSceneId) o;
        return Objects.equals(this.teacherId, entity.teacherId) &&
                Objects.equals(this.sceneId, entity.sceneId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(teacherId, sceneId);
    }

}