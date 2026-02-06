package org.example.repository;

import org.example.Entity.student;

import java.util.ArrayList;
import java.util.List;

public class StudentRepository {

    List<student> students=new ArrayList<>();

    public student getById(Integer id){
        for(student s:students){
            if(s.getId()==id){
                return s;
            }
        }
        return null;
    }
public List<student> findAll(){
    return students;
}
    public void save(student Student){
        students.add(Student);
    }

    public void update(student updatedstudent){
        for(int index=0;index<students.size();index++){
            if(students.get(index).getId()==updatedstudent.getId()) {

                students.set(index, updatedstudent);

                break;

            }



        }


    }
}
