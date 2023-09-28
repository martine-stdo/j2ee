package edu.whpu.pojo;


import java.util.List;

public class TbClass {

  private long id;
  private String classname;



  private List<TbStudent> studentList;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getClassname() {
    return classname;
  }

  public void setClassname(String classname) {
    this.classname = classname;
  }


  public List<TbStudent> getStudentList() {
    return studentList;
  }

  public void setStudentList(List<TbStudent> studentList) {
    this.studentList = studentList;
  }

  @Override
  public String toString() {
    return "TbClass{" +
            "id=" + id +
            ", classname='" + classname + '\'' +
            ", studentList=" + studentList +
            '}';
  }
}
