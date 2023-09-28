package edu.whpu;

import edu.whpu.mapper.IClassMapper;
import edu.whpu.mapper.IStudentMapper;
import edu.whpu.pojo.Class;
import edu.whpu.pojo.Student;
import edu.whpu.utils.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class MyBatisTest {
    private SqlSessionFactory sqlSessionFactory;
    private SqlSession sqlSession;

    @Before
    public void setUp() {
        // 获取 SqlSessionFactory 实例
        sqlSessionFactory = SqlSessionFactoryUtil.getSqlSessionFactory();
        // 打开一个 SqlSession
        sqlSession = sqlSessionFactory.openSession();
    }

    @After
    public void tearDown() {
        // 关闭 SqlSession
        sqlSession.close();
    }

    @Test
    public void testGetStudentById() {
        // 获取学生 Mapper 接口
        IStudentMapper studentMapper = sqlSession.getMapper(IStudentMapper.class);

        // 执行测试逻辑：查询id=2的学生的信息
        Student student = studentMapper.getStudentById(2);
        System.out.println("学生姓名：" + student.getName());
    }
    //插入学生
    @Test
    public void addStudent() {
        // 获取学生 Mapper 接口
        IStudentMapper studentMapper = sqlSession.getMapper(IStudentMapper.class);

        // 执行测试逻辑：插入学生
        Student student = new Student();
        student.setName("jack");
        student.setAge(20);
        student.setClass_id(1);
        int updatedRows = studentMapper.addStudent(student);
        // 插入数据库
        System.out.println("已插入 " + updatedRows + " 行记录");

        // 提交事务
        sqlSession.commit();
    }


    @Test
    public void testUpdateStudent() {
        // 获取学生 Mapper 接口
        IStudentMapper studentMapper = sqlSession.getMapper(IStudentMapper.class);

        // 执行测试逻辑：修改id=3的学生的姓名为“韩梅”，年龄为18
        Student updatedStudent = new Student();
        updatedStudent.setId(3);
        updatedStudent.setName("韩梅");
        updatedStudent.setAge(18);
        int updatedRows = studentMapper.updateStudent(updatedStudent);
        System.out.println("已更新 " + updatedRows + " 行记录");

        // 提交事务
        sqlSession.commit();
    }

    @Test
    public void testGetStudentsInClassTwo() {
        // 获取学生 Mapper 接口
        IStudentMapper studentMapper = sqlSession.getMapper(IStudentMapper.class);

        // 执行测试逻辑：查询二班所有学生的信息
        List<Student> studentsInClassTwo = studentMapper.getStudentsByClassId(2);
        System.out.println("二班学生列表：");
        for (Student s : studentsInClassTwo) {
            System.out.println("学生姓名：" + s.getName() + ", 年龄：" + s.getAge());
        }
    }

    @Test
    public void testGetClassAndStudentsByName() {
        // 获取班级 Mapper 接口
        IClassMapper classMapper = sqlSession.getMapper(IClassMapper.class);

        // 执行测试逻辑：查询班级以及对应的学生信息
        Class myClass = classMapper.getClassByName("二班");
        System.out.println("班级名称：" + myClass.getClassname());
        List<Student> studentsInMyClass = myClass.getStudentList();
        System.out.println("班级学生列表：");
        for (Student s : studentsInMyClass) {
            System.out.println("学生姓名：" + s.getName() + ", 年龄：" + s.getAge());
        }
    }
}
