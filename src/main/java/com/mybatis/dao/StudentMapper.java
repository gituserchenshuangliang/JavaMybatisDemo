package com.mybatis.dao;

import java.util.ArrayList;

import com.mybatis.entity.Student;
/**
 * mybatis访问接口
 * @author Cherry
 * 2020年5月28日
 */
public interface StudentMapper {
    Student findOne(int uuid);
    
    ArrayList<Student> findStudents(String[] param);
    
    int addStudent(Student Student);

    int deleteStudent(Student Student);

    int updateStudent(Student Student);
}
