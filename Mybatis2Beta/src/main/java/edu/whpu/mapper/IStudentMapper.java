package edu.whpu.mapper;

import edu.whpu.pojo.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IStudentMapper {
    // 使用@Select注解指定SQL语句，查询指定id的学生信息
    @Select("SELECT * FROM students WHERE id = #{id}")
    Student getStudentById(int id);

    // 使用@Update注解指定SQL语句，根据id更新学生的姓名和年龄
    @Update("UPDATE students SET name = #{name}, age = #{age} WHERE id = #{id}")
    int updateStudent(Student student);

    // 使用@Select注解指定SQL语句，查询指定班级id的所有学生信息
    @Select("SELECT * FROM students WHERE class_id = #{classId}")
    List<Student> getStudentsByClassId(int classId);

    // 使用@Insert注解指定SQL语句，插入学生信息
    @Insert("INSERT INTO students(name, age, class_id) VALUES(#{name}, #{age}, #{class_id})")
    int addStudent(Student student);
}
