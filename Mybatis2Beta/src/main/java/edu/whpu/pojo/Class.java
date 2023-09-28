package edu.whpu.pojo;

import java.util.List;

public class Class {
    private int id;
    private String classname;
    private List<Student> studentList; // 一个班级对应多个学生

    // Getter and setter methods for id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Getter and setter methods for classname
    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    // Getter and setter methods for studentList
    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }
}
