package com.nighterdream;

import com.nighterdream.Mapper.EmployeeMapper;
import com.nighterdream.Pojo.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class Demo2 {

    Employee tempEmployee = new Employee();

    @Test
    public void addEmployee() throws IOException {

        int id = 2;
        String name = "asuka";
        String age = "16";
        String position = "2号机驾驶员";

        tempEmployee.setId( id );
        tempEmployee.setName( name );
        tempEmployee.setAge( age );
        tempEmployee.setPosition( position );


        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        // 执行SQL
        sqlSession.insert("com.nighterdream.Mapper.EmployeeMapper.addEmployee", tempEmployee);
        sqlSession.commit();

        MyBatisUtils.closeSqlSession(sqlSession);
    }

    @Test
    public void delete() throws IOException {

        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        // 执行SQL
        sqlSession.delete("com.nighterdream.Mapper.EmployeeMapper.deleteEmployee", 2);
        sqlSession.commit();

        MyBatisUtils.closeSqlSession(sqlSession);
    }

    @Test
    public void update() throws IOException {
        // 接收参数
        //Scanner input = new Scanner(System.in);
        //System.out.println("请输入需要查找的用户Id:");
        int id = 1;
        String name = "Ikari Shinji ";
        String age = "14";
        String position = "初号机驾驶员";

        //封装对象
        tempEmployee.setId( id );
        tempEmployee.setName( name );
        tempEmployee.setAge( age );
        tempEmployee.setPosition( position );


        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        // 执行更新操作
        int rowCount = sqlSession.update("com.nighterdream.Mapper.EmployeeMapper.updateEmployee", tempEmployee);

        sqlSession.commit();
        MyBatisUtils.closeSqlSession(sqlSession);

        System.out.println("更新影响的行数：" + rowCount);
    }


    @Test
    public void findEmployeeById() throws IOException {
        int employeeIdToFind = 1; // 指定要查找的员工的ID

        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        // 执行根据ID查找操作，将ID传递给映射语句
        Employee employee = sqlSession.selectOne("com.nighterdream.Mapper.EmployeeMapper.findEmployee", employeeIdToFind);

        if (employee != null) {
            System.out.println("查找结果：" + employee);
        } else {
            System.out.println("未找到员工信息");
        }

        MyBatisUtils.closeSqlSession(sqlSession);
    }

}
