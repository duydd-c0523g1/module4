package com.validate_form.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

public class StudentDTO {
    @NotBlank(message = "Email cannot be blank")
    private String email;
    @NotBlank(message = "Username cannot be blank")
    private String username;
    @Size(min = 6, max = 18, message = "Password must be between 6-18 characters")
    private String password;
    @NotNull(message = "Choose at least 1 course")
    private Set<Course> courses;

    public StudentDTO() {
    }

    public StudentDTO(String email, String username, String password, Set<Course> courses) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.courses = courses;
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
