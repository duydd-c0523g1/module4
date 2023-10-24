package com.validate_form.repository;

import com.validate_form.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICourseRepository extends JpaRepository<Course, Integer> {
    List<Course> findAll();
}
