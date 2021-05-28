package com.zpc.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

// SqlSessionFactory --> SqlSession
public class MybatisUtils {
    public static SqlSession getSqlSession() {
        SqlSession sqlSession = null;
        SqlSessionFactory sqlSessionFactory = null;
        try {
            // 第一步 获取SqlSessionFactory对象
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sqlSession = sqlSessionFactory.openSession();
        return sqlSession;
    }
}
