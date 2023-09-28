package edu.whpu.pojo;


public class TbStudent {

  private long studentid;
  private String studentname;
  private long age;
  private long classId;


  public long getStudentid() {
    return studentid;
  }

  public void setStudentid(long studentid) {
    this.studentid = studentid;
  }


  public String getStudentname() {
    return studentname;
  }

  public void setStudentname(String studentname) {
    this.studentname = studentname;
  }


  public long getAge() {
    return age;
  }

  public void setAge(long age) {
    this.age = age;
  }


  public long getClassId() {
    return classId;
  }

  public void setClassId(long classId) {
    this.classId = classId;
  }

  @Override
  public String toString() {
    return "TbStudent{" +
            "studentid=" + studentid +
            ", studentname='" + studentname + '\'' +
            ", age=" + age +
            ", classId=" + classId +
            '}';
  }
}
