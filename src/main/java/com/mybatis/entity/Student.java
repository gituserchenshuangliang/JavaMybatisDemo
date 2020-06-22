package com.mybatis.entity;
/**
 * Entity
 * @author Cherry
 * 2020年5月28日
 */
public class Student {
    private int uuid;
    private String name;
    private String sex;
    private int teacherUuid;
    public int getUuid() {
        return uuid;
    }
    public void setUuid(int uuid) {
        this.uuid = uuid;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public int getTeacherUuid() {
        return teacherUuid;
    }
    public void setTeacherUuid(int teacherUuid) {
        this.teacherUuid = teacherUuid;
    }
    public Student(String name, String sex, int teacherUuid) {
        super();
        this.name = name;
        this.sex = sex;
        this.teacherUuid = teacherUuid;
    }
}
