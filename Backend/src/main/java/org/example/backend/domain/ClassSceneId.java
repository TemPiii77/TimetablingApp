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
public class ClassSceneId implements Serializable {
    private static final long serialVersionUID = 6394128390270695021L;
    @ColumnDefault("nextval('class_scene_class_id_seq')")
    @Column(name = "class_id", nullable = false)
    private Integer classId;

    @ColumnDefault("nextval('class_scene_scene_id_seq')")
    @Column(name = "scene_id", nullable = false)
    private Integer sceneId;

    public ClassSceneId() {
    }

    public ClassSceneId(Integer classId, Integer sceneId) {
        this.classId = classId;
        this.sceneId = sceneId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ClassSceneId entity = (ClassSceneId) o;
        return Objects.equals(this.classId, entity.classId) &&
                Objects.equals(this.sceneId, entity.sceneId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(classId, sceneId);
    }

}