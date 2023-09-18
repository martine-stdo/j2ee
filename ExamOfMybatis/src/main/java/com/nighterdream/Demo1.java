package com.nighterdream;

import com.nighterdream.Pojo.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class Demo1 {


    Employee tempEmployee = new Employee();

    @Test
    public void addEmployee() throws IOException {
        String name = "nighter";
        String age = "18";
        String position = "Engineer";

        //封装对象
        tempEmployee.setName( name );
        tempEmployee.setAge( age );
        tempEmployee.setPosition( position );

        // 1.加载mybatis的核心配置文件，获取SqlsessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);


        // 2.获取对应Sqlsession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 3.执行SQL
        sqlSession.insert("com.nighterdream.Mapper.EmployeeMapper.addEmployee", tempEmployee );
        sqlSession.commit();
        // 4.释放资源
        sqlSession.close();
    }

    @Test
    public void deletes() throws IOException {
        // 1.加载mybatis的核心配置文件，获取SqlsessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);


        // 2.获取对应Sqlsession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 3.执行SQL
        sqlSession.delete("com.nighterdream.Mapper.EmployeeMapper.deleteEmployee",2 );
        sqlSession.commit();
        // 4.释放资源
        sqlSession.close();
    }

    @Test
    public void updates() throws IOException {
        Integer id = 1;
        String name = "jumeos";
        String age = "25";
        String position = "CEO";

        //封装对象
        tempEmployee.setId(id);
        tempEmployee.setName(name);
        tempEmployee.setAge(age);
        tempEmployee.setPosition(position);

        // 1.加载mybatis的核心配置文件，获取SqlsessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);


        // 2.获取对应Sqlsession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 3.执行SQL
        int count = sqlSession.update("com.nighterdream.Mapper.EmployeeMapper.updateEmployee", tempEmployee );
        //影响的行数
        System.out.println(count);
        sqlSession.commit();
        // 4.释放资源
        sqlSession.close();
    }


    @Test
    public void finds() throws IOException {
        // 1.加载mybatis的核心配置文件，获取SqlsessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 2.获取对应Sqlsession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 3.执行SQL
        Employee employee = sqlSession.selectOne("com.nighterdream.Mapper.EmployeeMapper.findEmployee",2 );
        /* 输出语句快捷键 sout加回车*/
        System.out.println(employee);

        // 4.释放资源
        sqlSession.close();
    }

}
