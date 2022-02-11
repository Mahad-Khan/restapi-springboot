package com.springrest.restapi.services;

import com.springrest.restapi.dao.CourseDao;
import com.springrest.restapi.entities.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService{

    @Autowired
    private CourseDao courseDao;
//    List<Course> list;

    public CourseServiceImpl(){
//        list = new ArrayList<>();
//        list.add(new Course(1L,"English","New English"));
//        list.add(new Course(2L,"Urdu","New Urdu"));
//        list.add(new Course(3L,"Science","New Book Science"));
    }

    @Override
    public List<Course> getCourses() {
        return  courseDao.findAll();
    }

    @Override
    public  Course getCourse(Long courseId){
        return (Course) courseDao.findById(courseId).get();
    }

    @Override
    public Course addCourse(Course course){
       courseDao.save(course);
       return  course;
    }

    @Override
    public Course updateCourse(Course course){
      courseDao.save(course);
      return  course;
    }

    @Override
    public void deleteCourse(Long courseId){
        Course course = courseDao.getById(courseId);
        courseDao.delete(course);
    }
}
