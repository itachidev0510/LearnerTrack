package org.example.repository;

import org.example.Entity.Course;
import org.example.Entity.Enrollement;

import java.util.ArrayList;
import java.util.List;

public class EnrollmentRepository {

public List<Enrollement> enroll=new ArrayList<>();

public List<Enrollement> findAllEnrollements() {
    return enroll;
}
public void saveEnrollement(Enrollement enrollement) {
    enroll.add(enrollement);
}
public Enrollement getById(int id){
    for(Enrollement e:enroll){
        if(e.getId()==id){
            return e;
        }

    }
    return null;

}
public void UpdateEnrollement(Enrollement enrollement) {
    for(int index=0;index<enroll.size();index++){
        if(enroll.get(index).getId()==enrollement.getId()){
            enroll.set(index,enrollement);
            break;
        }

    }
}
}
