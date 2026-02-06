package org.example.service;

import org.example.Entity.Course;
import org.example.Entity.CourseStatus;
import org.example.Entity.student;
import org.example.Exception.EntityNotFoundException;
import org.example.repository.CourseRepository;
import org.example.util.InputValidator;

import java.util.List;

import static org.example.util.IdGenerator.getNextCourseId;

public class CourseService {

    CourseRepository courseRepository=new CourseRepository();
    InputValidator inputValidator=new InputValidator();

    public Course addCourse(String courseName,String courseDescription,int durationINweek) {
       //inputValidat₹or.validateCourseName(courseName);

       int id=getNextCourseId();

       Course course=new Course();
       course.setId(id);
       course.setCourseName(courseName);
       course.setDescription(courseDescription);
       course.setDurationInWeeks(durationINweek);
       course.setActive(CourseStatus.ACTIVE);
       courseRepository.save(course);

       return course;

    }
    public List<Course> findAllCourses(){
        return courseRepository.findall();
    }
    public Course removeCourse(int id){
        inputValidator.validateId(id);

        Course existingcourse=courseRepository.getbyid(id);

        if(existingcourse == null) {
            throw new EntityNotFoundException("Course with id "+id+" not found");
        }
        if(existingcourse.getActive()==CourseStatus.INACTIVE){
            throw new EntityNotFoundException("Course with id "+id+" is INACTIVE");
        }
        else
        {
            existingcourse.setActive(CourseStatus.INACTIVE);
        }
        courseRepository.save(existingcourse);
        return existingcourse;
    }


}
