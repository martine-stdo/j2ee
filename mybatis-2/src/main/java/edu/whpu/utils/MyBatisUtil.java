package edu.whpu.utils;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisUtil {
    private static SqlSessionFactory factory;

    static{//在静态代码块中，factory只会被创建一次
        System.out.println("static factory===============");
        try {
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            factory = new SqlSessionFactoryBuilder().build(is);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static SqlSession createSqlSession(){
        return factory.openSession(false);//true为自动提交事务
    }

    public static void closeSqlSession(SqlSession sqlSession){
        if(null != sqlSession)
            sqlSession.close();
    }
}


