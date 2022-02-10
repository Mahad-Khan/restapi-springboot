package com.springrest.restapi.controller;

import com.springrest.restapi.entities.Course;
import com.springrest.restapi.services.CourseService;
import com.springrest.restapi.services.CourseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

        return this.courseService.getCourses();
    }

    //get a course
    @GetMapping("/courses/{courseId}")
    public Course  getCourse(@PathVariable String courseId){
        return this.courseService.getCourse(Long.parseLong(courseId));
    }

    @PostMapping("/courses")
    public Course addCourse(@RequestBody Course course){
        return this.courseService.addCourse(course);

    }

    @PutMapping("/courses")
    public Course updateCourse(@RequestBody Course course){
        return this.courseService.updateCourse(course);
    }

    @DeleteMapping("/courses/{courseId}")
    public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseId) {
        try {
            this.courseService.deleteCourse(Long.parseLong(courseId));
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
