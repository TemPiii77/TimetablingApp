package org.example.backend.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@Entity
@Table(name = "preferred_time")
public class PreferredTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ColumnDefault("nextval('preferred_time_id_seq')")
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "day", nullable = false, length = 10)
    private String day;

    @Column(name = "hour", nullable = false)
    private Short hour;

}