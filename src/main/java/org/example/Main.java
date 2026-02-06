package org.example;

import org.example.Constants.AppConstant;
import org.example.Constants.MenuOptions;
import org.example.Entity.Course;
import org.example.Entity.Enrollement;
import org.example.Entity.student;
import org.example.Exception.EntityNotFoundException;
import org.example.Exception.InvalidInputException;
import org.example.repository.CourseRepository;
import org.example.service.CourseService;
import org.example.service.EnrollmentService;
import org.example.service.StudentService;

import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String programStrat = AppConstant.WelcomeMessage;
        System.out.println(programStrat);

        Scanner scanner = new Scanner(System.in);

        StudentService studentService = new StudentService();
        CourseService courseService = new CourseService();
        EnrollmentService enrollmentService = new EnrollmentService();

        boolean running = true;
        while (running) {

            System.out.println("======The listed below are the menu options");
            System.out.println(MenuOptions.ADD_STUDENT + " - Add student");
            System.out.println(MenuOptions.View_All_STUDENT + " - View all students");
            System.out.println(MenuOptions.Find_Student_BY_ID + " - Find student by id");
            System.out.println(MenuOptions.DEACTIVATE_STUDENT + " - Deactivate student");
            System.out.println(MenuOptions.ADD_New_COURSE + " - Add new course");
            System.out.println(MenuOptions.View_All_COURSE + " - View all courses");
            System.out.println(MenuOptions.DEACTIVATE_COURSE + " - Deactivate course");
            System.out.println(MenuOptions.Enroll_New_COURSE + " - Enroll new course");
            System.out.println(MenuOptions.EnrollementList_ID + " - View all courses by id");
            System.out.println(MenuOptions.EnrollementStatusUpdateBY_ID + " - Update course by id");
            System.out.println(MenuOptions.exit+"-Exit");
            int option = scanner.nextInt();

            try {
                switch (option) {

                    case MenuOptions.ADD_STUDENT:
                       String AddStudent= AppConstant.AddNewCourseMessage;
                        System.out.println("Enter the First Name of the student you want to add");
                        String firstName = scanner.next();
                        System.out.println("Enter the Last Name of the student you want to add");
                        String lastName = scanner.next();
                        System.out.println("Enter the Student email");
                        String email = scanner.next();

                        student addedStudent = studentService.addStudent(firstName, lastName, email);
                        System.out.println("Student added with id"+" "+addedStudent.getId());

                        break;
                        case MenuOptions.View_All_STUDENT:
                            List<student>allstudent=studentService.findAll();
                            if(allstudent.isEmpty()){
                                throw new EntityNotFoundException("No student found");

                            }
                            for (student student : allstudent) {
                                System.out.println("Student Id: "+student.getId());
                                System.out.println("Student FirstName: "+student.getFirstName());
                                System.out.println("Student Email: "+student.getEmail());
                                System.out.println("Student LastName: "+student.getLastName());
                                System.out.println("Student Active: "+student.getActive());
                            }

                            break;

                            case MenuOptions.Find_Student_BY_ID:
                                int studentId = scanner.nextInt();
                                student getstudent=studentService.findById(studentId);
                                System.out.println("Student Id: "+getstudent.getId());


                                break;

                                case MenuOptions.DEACTIVATE_STUDENT:

                                    System.out.println("Enter the Student Id you want to deactivate");

                                    int studentIds = scanner.nextInt();

                                    if(studentIds<1){
                                        throw new InvalidInputException("Invalid Student Id");
                                    }
                                    student deactivate=studentService.removeStudent(studentIds);

                                    System.out.println("Student deactivated with id"+deactivate.getId());

                                    break;
                                    case MenuOptions.ADD_New_COURSE:
                                        System.out.println(AppConstant.AddNewCourseMessage);
                                        String courseName = scanner.next();
                                        System.out.println("Enter Duration of the course you want to add");
                                        int duration = scanner.nextInt();
                                        System.out.println("Enter Description of the course you want to add");
                                        String description = scanner.next();

                                        Course addcourse=courseService.addCourse(courseName,description,duration);
                                        System.out.println("Course added with id"+addcourse.getId());

                                        break;
                                        case MenuOptions.View_All_COURSE:
                                            List<Course> listOfAllCourse=courseService.findAllCourses();
                                            if (listOfAllCourse.isEmpty()) {
                                                throw new EntityNotFoundException("No course found");
                                            }
                                            for (Course course : listOfAllCourse) {
                                                System.out.println("Course Id: "+course.getId());
                                                System.out.println("Course Name" + course.getCourseName());
                                                System.out.println("Course Description" + course.getDescription());
                                                System.out.println("Course duration" + course.getDurationInWeeks());
                                            }
                                            break;
                                            case MenuOptions.DEACTIVATE_COURSE:
                                                System.out.println("Enter course Id you want to deactivate");

                                                int courseIds = scanner.nextInt();

                                                if(courseIds<1){
                                                    throw new InvalidInputException("Invalid course Id");
                                                }
                                                Course deactivatecourse=courseService.removeCourse(courseIds);
                                                System.out.println("Course deactivated with id"+deactivatecourse.getId());
                                                break;
                                                case MenuOptions.Enroll_New_COURSE:
                                                    System.out.println("Enter course Id you want to enroll");
                                                    int courseId = scanner.nextInt();
                                                    System.out.println("Enter Student Id you want to enroll");
                                                    int studentid=scanner.nextInt();

                                                    Enrollement addedenroll=enrollmentService.EnrollStudentInCourse(studentid,courseId);

                                                    System.out.println("Student enrolled with id"+addedenroll.getId());

                                                    break;
                                                    case MenuOptions.EnrollementList_ID:
                                                        List<Enrollement> enroll=enrollmentService.findEnrollement();
                                                        if(enroll.isEmpty()){
                                                            throw new EntityNotFoundException("No enrollement found");
                                                        }
                                                        for (Enrollement enrollement : enroll) {
                                                            System.out.println("Enrollement Id: "+enrollement.getId());
                                                            System.out.println("Student Id: "+enrollement.getId());
                                                            System.out.println("Course Id"+enrollement.getCourseId());
                                                            System.out.println("status" +enrollement.getStatus());
                                                            System.out.println("enroldate"+enrollement.getEnrolledDate());
                                                        }
                                                        break;


                    case MenuOptions.exit:
                        System.out.println("Thank for your response");
                        running = false;
                        break;

                }

            }catch (InvalidInputException e){
                System.out.println(e.getMessage());
            }

        }
        scanner.close();
        System.out.println("Thank you for using this program");




    }
}