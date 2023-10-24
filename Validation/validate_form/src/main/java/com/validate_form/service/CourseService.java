package com.validate_form.service;

import com.validate_form.model.Course;
import com.validate_form.repository.ICourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService implements ICourseService {
    @Autowired
    private ICourseRepository courseRepository;
    @Override
    public List<Course> findAllCourse() {
        return courseRepository.findAll();
    }
}
