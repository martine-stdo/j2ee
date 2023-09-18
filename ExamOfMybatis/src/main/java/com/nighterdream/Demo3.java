package com.nighterdream;

import com.nighterdream.Mapper.EmployeeMapper;
import com.nighterdream.Pojo.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class Demo3 {
    private SqlSession sqlSession;

    @Before
    public void setup() throws IOException {
        // 1.加载mybatis的核心配置文件，获取SqlsessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 2.获取对应Sqlsession对象
        sqlSession = sqlSessionFactory.openSession();
    }

    @After
    public void tearDown() {
        if (sqlSession != null) {
            sqlSession.close();
        }
    }

    @Test
    public void add() {
        int id = 4;
        String name = "alice";
        String age = "22";
        String position = "boss";

        Employee employee = new Employee();
        employee.setId(id);
        employee.setName(name);
        employee.setAge(age);
        employee.setPosition(position);

        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
        employeeMapper.addEmployee(employee);
        sqlSession.commit();
    }

    @Test
    public void delete() {
        int id = 4;

        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
        employeeMapper.deleteEmployee(id);
        sqlSession.commit();
    }

    @Test
    public void update() {
        int id = 4;
        String name = "spkie";
        String age = "22";
        String position = "agent";

        Employee employee = new Employee();
        employee.setId(id);
        employee.setName(name);
        employee.setAge(age);
        employee.setPosition(position);

        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
        int count = employeeMapper.updateEmployee(employee);
        System.out.println(count);
        sqlSession.commit();
    }

    @Test
    public void find() {
        int id = 2;

        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
        Employee employees = employeeMapper.findEmployee(id);
        System.out.println(employees);
    }
}
