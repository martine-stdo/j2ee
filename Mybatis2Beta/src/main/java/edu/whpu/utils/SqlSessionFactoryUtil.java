package edu.whpu.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class SqlSessionFactoryUtil {
    // 创建静态变量以保持唯一的 SqlSessionFactory 实例
    private static SqlSessionFactory sqlSessionFactory;

    // 私有构造方法，防止外部实例化
    private SqlSessionFactoryUtil() {}

    // 获取或创建 SqlSessionFactory 实例
    public static SqlSessionFactory getSqlSessionFactory() {
        if (sqlSessionFactory == null) {
            // 使用 synchronized 块确保多线程安全创建 SqlSessionFactory
            synchronized (SqlSessionFactoryUtil.class) {
                if (sqlSessionFactory == null) {
                    try {
                        // 指定 MyBatis 配置文件的路径
                        String resource = "mybatis-config.xml";
                        // 从类路径加载配置文件
                        InputStream inputStream = Resources.getResourceAsStream(resource);
                        // 使用 SqlSessionFactoryBuilder 创建 SqlSessionFactory 实例
                        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
                    } catch (IOException e) {
                        e.printStackTrace();
                        // 如果出现异常，抛出运行时异常以指示 MyBatis 初始化失败
                        throw new RuntimeException("MyBatis initialization failed.");
                    }
                }
            }
        }
        // 返回 SqlSessionFactory 实例
        return sqlSessionFactory;
    }
}
