package com.validate_form.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String email;
    private String username;
    private String password;
    @ManyToMany
    @JoinTable(name = "student_course", joinColumns = @JoinColumn(name = "std_id"), inverseJoinColumns = @JoinColumn(name = "crs_id"))
    private Set<Course> courses;

    public Student() {
    }

    public Student(Integer id, String email, String username, String password, Set<Course> course) {
        this.id = id;
        this.email = email;
        this.username = username;
        this.password = password;
        this.courses = course;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }
}
