package org.example.backend.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "\"user\"")
public class User {
    @Id
    @Column(name = "id", nullable = false, length = 6)
    private String id;

    @Column(name = "email", nullable = false, length = 100)
    private String email;

    @Column(name = "last_name", nullable = false, length = 100)
    private String lastName;

    @Column(name = "first_name", nullable = false, length = 100)
    private String firstName;

    @Column(name = "password", nullable = false, length = 128)
    private String password;

    @Column(name = "role", nullable = false, length = 20)
    private String role;

}