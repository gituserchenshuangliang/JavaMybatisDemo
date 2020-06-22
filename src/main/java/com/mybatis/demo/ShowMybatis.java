package com.mybatis.demo;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mybatis.dao.TeacherMapper;
import com.mybatis.entity.Teacher;

/**
 * 演示
 * @author Cherry
 * 2020年5月28日
 */
public class ShowMybatis {
    public static void main(String[] args) {
        TeacherMapper tm = getSqlSession().getMapper(TeacherMapper.class);
        Teacher t = tm.findOne(1);
        System.out.println(t);
    }
    
    public static SqlSession getSqlSession() {
        SqlSessionFactory factory = null;
        try {
            String config = "config/mybatis-config.xml";
            
            InputStream in = Resources.getResourceAsStream(config);
            
            factory = new SqlSessionFactoryBuilder().build(in);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        return factory.openSession();
    }
}
