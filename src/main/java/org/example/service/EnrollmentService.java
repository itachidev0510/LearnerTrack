package org.example.service;

import org.example.Entity.*;
import org.example.Exception.InvalidInputException;
import org.example.repository.CourseRepository;
import org.example.repository.EnrollmentRepository;
import org.example.repository.StudentRepository;
import org.example.util.InputValidator;

import java.time.LocalDate;
import java.util.List;

import static org.example.util.IdGenerator.getNextEnrollId;

public class EnrollmentService {

    EnrollmentRepository enrollmentRepository=new EnrollmentRepository();
    InputValidator inputValidator=new InputValidator();
   StudentRepository studentRepository=new StudentRepository();
    CourseRepository courseRepository=new CourseRepository();
//public EnrollmentService(StudentRepository studentRepository,CourseRepository courseRepository,EnrollmentRepository enrollmentRepository) {
//    this.studentRepository=studentRepository;
//    this.courseRepository=courseRepository;
//    this.enrollmentRepository=enrollmentRepository;
//}
    public Enrollement EnrollStudentInCourse(int studentId, int courseId){
        inputValidator.validateId(studentId);
        inputValidator.validateId(courseId);
        int id=getNextEnrollId();

        Enrollement enrollement = new Enrollement();
        enrollement.setId(id);


//        if(studentRepository.getById(studentId).getActive()!=true && courseRepository.getbyid(courseId).getActive()!=CourseStatus.ACTIVE){}
//        { throw new InvalidInputException("Student or Course is not active");
//        }
        student student=studentRepository.getById(studentId);

        if(student== null || student.getActive()!=true)
        {
            throw new InvalidInputException("Student not found");
        }

        enrollement.setStudentId(studentId);
         Course    c =courseRepository.getbyid(courseId);
        {
           if(c== null ||c.getActive()!=CourseStatus.ACTIVE) {
               throw new InvalidInputException("Course not found");
           }
            enrollement.setCourseId(courseId);
            enrollement.setStatus(EnrollementStatus.ACTIVE);
            enrollement.setEnrolledDate(LocalDate.now());

            enrollmentRepository.saveEnrollement(enrollement);

            return enrollement;
        }





    }
    public List<Enrollement> findEnrollement(){
        return enrollmentRepository.findAllEnrollements();
    }

    public Enrollement updateEnrollement(Enrollement enrollement){
        if(enrollement==null)
        {
            throw new InvalidInputException("passed Enrolment is null");
        }

        Enrollement existingEnrollement=enrollmentRepository.getById(enrollement.getId());
        if(existingEnrollement==null){
            throw  new InvalidInputException("Enrolment not found");
        }
        int studentid=existingEnrollement.getStudentId();
        int courseid=existingEnrollement.getCourseId();
        student student=studentRepository.getById(studentid);
        Course course=courseRepository.getbyid(courseid);
        if(course==null)
        {throw new InvalidInputException("Course not found");}

        if(student==null){throw new InvalidInputException("Student not found");}
        if(student.getActive()!=true)
        {
            existingEnrollement.setStatus(EnrollementStatus.CANCELLED);
        } else if
        (course.getActive()==CourseStatus.INACTIVE){
            existingEnrollement.setStatus(EnrollementStatus.CANCELLED);
        }
        else {
            existingEnrollement.setStatus(EnrollementStatus.ACTIVE);
        }

        enrollmentRepository.UpdateEnrollement(existingEnrollement);

        return existingEnrollement;
    }
}
