package org.example.service;

import org.example.Entity.student;
import org.example.Exception.InvalidInputException;
import org.example.repository.StudentRepository;
import org.example.util.InputValidator;

import java.util.List;

import static org.example.util.IdGenerator.getNextStudentId;

public class StudentService {
    StudentRepository studentRepository=new StudentRepository();
    InputValidator inputValidator=new InputValidator();



    public student addStudent(String lastname, String firstname, String email) {
        inputValidator.ValidateLastName(lastname);
        inputValidator.validateFirstName(firstname);
        inputValidator.validateEmail(email);

        int id = getNextStudentId();

        student students = new student();
        students.setId(id);
        students.setLastName(lastname);
        students.setFirstName(firstname);
        students.setEmail(email);
        students.setActive(true);
        studentRepository.save(students);
        return students;

    }

    public student updateStudent(student student) {
        if (student == null) {
            throw new InvalidInputException("Invalid Student format Or Null values send");

        }
        inputValidator.validateId(student.getId());

        student existingStudent = studentRepository.getById(student.getId());
        if (existingStudent == null) {
            throw new InvalidInputException("Student not found");
        }

        if (existingStudent != null && existingStudent.getActive() == true) {
            existingStudent.setEmail(student.getEmail());
            existingStudent.setFirstName(student.getFirstName());
            existingStudent.setLastName(student.getLastName());

            studentRepository.update(existingStudent);

        }
        return existingStudent;


    }

    public student removeStudent(int id) {
        student existingStudent = studentRepository.getById(id);
//       if(student==null){
//           throw new InvalidInputException("Invalid student parsed ");
//       }
        inputValidator.validateId(id);
        //student existingStudent=studentRepository.getById(student.getId());
        if (existingStudent == null) {
            throw new InvalidInputException("Student not found");
        }
        if (existingStudent.getActive() == false) {
            throw new InvalidInputException("Student already removed");
        } else {
            existingStudent.setActive(false);
            studentRepository.update(existingStudent);
        }
        return existingStudent;
    }

    public List<student> findAll() {
        return studentRepository.findAll();

    }
    public student findById(int id) {
        return studentRepository.getById(id);
    }
}
