package org.example.repository;

import org.example.Entity.Course;

import java.util.ArrayList;
import java.util.List;

public class CourseRepository {
    List<Course> courses = new ArrayList<>();

    public Course getbyid(int id) {
        for (Course c : courses) {
            if (c.getId() == id) {
                return c;
            }
        }
        return null;
    }

    public void save(Course course) {
        courses.add(course);
    }

    public List<Course> findall() {
        return courses;
    }


    public void update(Course coursestatus) {
        for (int index = 0; index < courses.size(); index++) {
            if (courses.get(index).getId() == coursestatus.getId()) {

                courses.set(index, coursestatus);

                break;

            }


        }
    }
}



