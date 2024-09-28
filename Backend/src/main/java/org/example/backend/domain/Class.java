package org.example.backend.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@Entity
@Table(name = "class")
public class Class {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ColumnDefault("nextval('class_id_seq')")
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "year", nullable = false)
    private Short year;

    @Column(name = "grade", nullable = false)
    private Short grade;

    @Column(name = "\"group\"", nullable = false, length = Integer.MAX_VALUE)
    private String group;

    @Column(name = "field", nullable = false, length = 300)
    private String field;

}