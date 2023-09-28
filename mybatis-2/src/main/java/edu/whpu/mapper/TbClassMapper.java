package edu.whpu.mapper;

import org.apache.ibatis.annotations.*;
import edu.whpu.pojo.TbClass;
import edu.whpu.pojo.TbStudent;

import java.util.List;
@Mapper
public interface TbClassMapper {

    @Select("select * from tb_class where id=#{id}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "classname", column = "classname"),
            @Result(property = "studentList", column = "id", javaType = List.class, many = @Many(select = "edu.whpu.mapper.TbStudentMapper.findStudentByClass"))})
    TbClass selectAllStudentByClass(Integer id);
}

