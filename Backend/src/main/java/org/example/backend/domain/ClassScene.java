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
@Table(name = "class_scene")
public class ClassScene {
    @EmbeddedId
    private ClassSceneId id;

    @MapsId("classId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @ColumnDefault("nextval('class_scene_class_id_seq')")
    @JoinColumn(name = "class_id", nullable = false)
    private Class classField;

    @MapsId("sceneId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @ColumnDefault("nextval('class_scene_scene_id_seq')")
    @JoinColumn(name = "scene_id", nullable = false)
    private Scene scene;

}