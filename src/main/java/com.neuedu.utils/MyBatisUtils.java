package com.neuedu.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class MyBatisUtils {
    private  static  SqlSessionFactory sqlSessionFactory=null;
    static{
        String resource="mybatis-config.xml";
        Reader reader = null;
        SqlSession session;
        try {
            reader = Resources.getResourceAsReader(resource);
            //        2生成SqlSessionFactory 为SqlSession的工厂,用于建立与数据库的会话。
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public static  SqlSessionFactory getSqlSessionFactory(){
        return  sqlSessionFactory;
    }

    public static void close(SqlSession session) {
         session.close();
    }
}
