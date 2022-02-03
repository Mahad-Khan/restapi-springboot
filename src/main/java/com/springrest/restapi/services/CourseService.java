package com.springrest.restapi.services;

import com.springrest.restapi.entities.Course;

import java.util.List;

public interface CourseService {

    public List<Course> getCourses();
    public Course getCourse(Long courseId);
    public COurse addCourse(Course course);
}
