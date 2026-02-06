package org.example.Entity;

public class Course {
    private int id;
    private String courseName;
    private String description;
    private int durationInWeeks;

    private CourseStatus active;

    public Course(String courseName, String description, int durationInWeeks) {

        this.courseName=courseName;
        this.description=description;
        this.durationInWeeks=durationInWeeks;

    }

    public Course() {

    }


    public int getDurationInWeeks() {
        return durationInWeeks;
    }

    public void setDurationInWeeks(int durationInWeeks) {
        this.durationInWeeks = durationInWeeks;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CourseStatus getActive() {
        return active;
    }

    public void setActive(CourseStatus active) {
        this.active = active;
    }
}