package edu.whpu.mapper;

import edu.whpu.pojo.Class;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IClassMapper {
    // 使用@Select注解指定SQL语句，查询班级信息
    @Select("SELECT * FROM classes WHERE name = #{classname}") // 更改为"name"
    @Results({
            // 使用@Result注解进行结果映射
            // 将数据库表中的"id"列映射到类的"id"属性
            @Result(property = "id", column = "id"),
            // 将数据库表中的"name"列映射到类的"classname"属性（在结果中保持名称不变）
            @Result(property = "classname", column = "name"), // 更改为"name"
            // 使用嵌套查询，将数据库表中的"id"列关联到类的"studentList"属性
            @Result(
                    property = "studentList",
                    javaType = List.class, // 指定属性类型为List
                    column = "id", // 使用"id"列作为关联条件
                    many = @Many(select = "edu.whpu.mapper.IStudentMapper.getStudentsByClassId")
            )
    })
    Class getClassByName(String classname); // 根据班级名称查询班级信息
}
