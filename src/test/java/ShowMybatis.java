import java.util.HashMap;
import java.util.List;

import com.mybatis.dao.ClassRoomMapper;
import com.mybatis.dao.StudentMapper;
import com.mybatis.entity.ClassRoom;
import com.mybatis.entity.Student;
import com.mybatis.typehandle.SexEnum;
import com.mybatis.util.MySessionUtil;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.mybatis.dao.TeacherMapper;
import com.mybatis.entity.Teacher;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * 演示
 * @author Cherry
 * 2020年5月28日
 */
public class ShowMybatis {
    SqlSession session = null;
    TeacherMapper mapper = null;
    StudentMapper mapper2 = null;
    ClassRoomMapper mapper3 = null;
    @Before
    public void beforeTest(){
        if(session == null) session = MySessionUtil.getSqlSession();
        if(mapper == null) mapper = session.getMapper(TeacherMapper.class);
        if(mapper2 == null) mapper2 = session.getMapper(StudentMapper.class);
        if(mapper3 == null) mapper3 = session.getMapper(ClassRoomMapper.class);
    }

    @Test
    public void addTeacher(){
        Teacher t2 = new Teacher("上官琴",26, "Dance", "F",4500);
        mapper.addTeacher(t2);
        //生成的主键赋值给t2
        MySessionUtil.println(t2.getUuid());
    }

    @Test
    public void deleteTeacher(){
    mapper.deleteTeacher(19);
    }

    @Test
    public void updateTeacher(){
        Teacher t = new Teacher();
        t.setUuid(22);
        t.setName("尉迟洪");
        mapper.updateTeacher(t);
    }

    @Test
    public void findOne(){
        mapper.findOne(22);
    }

    @Test
    public void findTeachers(){
        HashMap<String, Object> map = new HashMap<>();
        //Mybatis分页类
        RowBounds row = new RowBounds(1,2);
        map.put("major","c");
        int i = mapper.findTeachers(map,row).size();
        MySessionUtil.println(i);
    }

    @Test
    public void findTeacherField(){
        HashMap<String, Object> maps = new HashMap<>();
        mapper.findTeacherField(maps,3,1);
    }
    
    @Test
    public void findOneStu(){
        Student s = mapper2.findOne(4);
        MySessionUtil.println(s);
    }

    @Test
    public void findStuByClass(){
        List<Student> s = mapper2.findByClassId(1);
        MySessionUtil.println(s);
    }

    @Test
    public void findClassRoom(){
        ClassRoom s = mapper3.findByUuid(1);
        MySessionUtil.println(s.getTeacher());
        MySessionUtil.println("准备调用List,延时加载，调用时才执行SQL");
        MySessionUtil.println(s.getList());
    }

    @Test
    public void addStu(){
        Student s = new Student();
        s.setName("祝龙");
        s.setSex(SexEnum.FEMAL);
        s.setClassUuid(2);
        mapper2.addStudent(s);
        MySessionUtil.println(s);
    }
    
    @After
    public void afterTest(){
        if(session != null) session.commit();
    }
}
