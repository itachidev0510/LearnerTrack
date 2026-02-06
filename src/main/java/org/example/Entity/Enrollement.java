package org.example.Entity;

import java.time.LocalDate;
import java.util.Date;

public class Enrollement {
private int id;
private int studentId;
private int courseId;
private LocalDate enrolledDate;
private EnrollementStatus enrollementStatus;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getEnrolledDate() {
        return enrolledDate;
    }

    public void setEnrolledDate(LocalDate enrolledDate) {
        this.enrolledDate = enrolledDate;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }



    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public EnrollementStatus getStatus() {
        return enrollementStatus;
    }


    public void setStatus(EnrollementStatus enrollementStatus) {
        this.enrollementStatus = enrollementStatus;
    }
}
