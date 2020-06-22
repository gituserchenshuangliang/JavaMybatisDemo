package com.mybatis.dao;

import java.util.ArrayList;

import com.mybatis.entity.Teacher;
/**
 * mybatis访问接口
 * @author Cherry
 * 2020年5月28日
 */
public interface TeacherMapper {
    Teacher findOne(int uuid);
    
    ArrayList<Teacher> findTeachers(String[] param);
    
    int addTeacher(Teacher teacher);

    int deleteTeacher(Teacher teacher);

    int updateTeacher(Teacher teacher);
}
