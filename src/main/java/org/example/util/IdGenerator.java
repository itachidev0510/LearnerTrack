package org.example.util;



public class IdGenerator {

    public static int NextStudentID;

    public static int NextCourseId;

    public static int NextEnrollId;

    public  static int getNextStudentId(){
    return ++NextStudentID;
    }
    public  static int getNextCourseId(){
        return ++NextCourseId;
    }
    public  static int getNextEnrollId(){
        return ++NextEnrollId;
    }
}
