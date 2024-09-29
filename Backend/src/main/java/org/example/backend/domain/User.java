package org.example.backend.domain;

import jakarta.persistence.*;
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




    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Admin admin;

    public void setAdmin(Admin admin) {
        this.admin = admin;
        this.admin.setUser(this);
    }

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Teacher teacher;

    public void setTeacher(Teacher teacher, String jobTitle) {
        this.teacher = teacher;
        this.teacher.setUser(this);
        this.teacher.setJobTitle(jobTitle);
    }

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Student student;

    public void setStudent(Student student) {
        this.student = student;
        this.student.setUser(this);
    }


}