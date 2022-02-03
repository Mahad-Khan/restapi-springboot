package com.springrest.restapi.controller;

import com.springrest.restapi.entities.Course;
import com.springrest.restapi.services.CourseService;
import com.springrest.restapi.services.CourseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MyController {

    @Autowired //create object automatically
    private  CourseService courseService;

    @GetMapping("/home")
    public String home(){
        return "HOME";
    }

    //get the list of courses
    @GetMapping("/courses")
    public List<Course>  getCourses(){
        // have to call services
        return this.courseService.getCourses();
    }

    //get a course
    @GetMapping("/courses/{courseId}")
    public Course  getCourse(@PathVariable String courseId){
        // have to call services
        return this.courseService.getCourse(Long.parseLong(courseId));
    }

    @PostMapping("/courses")
    public Course addCourse(@RequestBody Course course){
        return this.courseService.addCourse(course);

    }
}
