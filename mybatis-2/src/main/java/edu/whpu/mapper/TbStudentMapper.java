package edu.whpu.mapper;

import edu.whpu.pojo.TbStudent;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TbStudentMapper {
    // 查询学生信息
    @Select("SELECT * FROM tb_student WHERE id = #{id}")
    TbStudent getStudentById(@Param("id") int id);

    // 修改学生信息
    @Update("UPDATE student SET name = #{tb_student.name}, age = #{tb_student.age} WHERE id = #{tb_student.id}")
    void updateStudent(@Param("student") TbStudent student);

    // 查询指定班级学生信息
    @Select("select * from tb_student where class_id=#{class_Id}")
    List<TbStudent> findStudentByClass(Integer id);

}