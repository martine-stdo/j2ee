package edu.whpu.test;

import edu.whpu.mapper.TbClassMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;
import edu.whpu.pojo.TbClass;
import edu.whpu.pojo.TbStudent;
import edu.whpu.utils.MyBatisUtil;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TbClassTest {
    private Logger logger= Logger.getLogger(TbClassTest.class);

    /*
    一对多关联查询，根据班级id查询出所有的学生
     */
    @Test
    void getId() {
        SqlSession session= MyBatisUtil.createSqlSession();


        TbClass tbClass= session.getMapper(edu.whpu.mapper.TbClassMapper.class).selectAllStudentByClass(2);
        List<TbStudent> tbStudents=tbClass.getStudentList();
        for(TbStudent tbStudent:tbStudents){
            System.out.println(tbStudent);
//            logger.info("学生id："+tbStudent.getStudentid()+"，学生姓名："+tbStudent.getStudentname()+"，年龄:"+tbStudent.getAge()+"，班级："+tbClass.getClassname());
        }
        session.close();
    }
}
