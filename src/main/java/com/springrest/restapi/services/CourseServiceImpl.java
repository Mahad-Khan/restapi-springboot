package com.springrest.restapi.services;

import com.springrest.restapi.entities.Course;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService{

    List<Course> list;

    public CourseServiceImpl(){
        list = new ArrayList<>();
        list.add(new Course(1L,"English","New English"));
        list.add(new Course(2L,"Urdu","New Urdu"));
        list.add(new Course(3L,"Science","New Book Science"));
    }

    @Override
    public List<Course> getCourses() {
        return list;
    }

    @Override
    public  Course getCourse(Long courseId){
        Course c = null;
        for(Course course:list){
            if(course.getId() == courseId) {
                c = course;
                break;
            }
        }
        return c;
    }

    @Override
    public Course addCourse(Course course){
        this.list.add(course);
        return course;
    }
}
