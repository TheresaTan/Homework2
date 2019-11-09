package com.cpsc41102.homework2.model;

import java.util.ArrayList;

public class StudentDB {
    private static final StudentDB ourInstance = new StudentDB();

    protected ArrayList<Student> mStudent;

    static public StudentDB getInstance(){
        return ourInstance;
    }

    private StudentDB(){
//        createStudentObjects();
    }

    public ArrayList<Student> getStudent(){
        return mStudent;
    }

    public void setStudent(ArrayList<Student> student){
        mStudent = student;
    }

    protected void createStudentObjects(){
        Student student = new Student("Theresa", "Tanubrata", "123456789");
//        ArrayList<Student> studentList = new ArrayList<>();
        mStudent.add(student);


        student = new Student("Marie","Bae","234567891");
        mStudent.add(student);

        student = new Student("Joann","Fu","987654321");
        mStudent.add(student);

        //
//        StudentDB.getInstance().setStudent(studentList);

    }
}
