package com.itheima.dymatic;

import com.itheima.bean.Student;
import com.itheima.mapper.StudentMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author sqh
 * @create 2021-04-06 1:00
 */
public class Test01 {
    @Test
    public void selectCondition() throws Exception{
        InputStream is = Resources.getResourceAsStream("MyBatisConfig.xml");

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);

        SqlSession sqlSession = sqlSessionFactory.openSession(true);//这个才是真正帮助我们实现功能的对象

        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);//实现类

        Student stu = new Student();
        stu.setId(6);
//        stu.setName("米老鼠");//使用if标签
        stu.setAge(6);

        //当条件为一个或者多个时候，都能根据现状实现查询
        List<Student> list = mapper.selectCondition(stu);//调用多条件查询

        for (Student student : list) {
            System.out.println(student);
        }

        sqlSession.close();
        is.close();
    }
    @Test
    public void selectByIds() throws Exception{
        InputStream is = Resources.getResourceAsStream("MyBatisConfig.xml");

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);

        SqlSession sqlSession = sqlSessionFactory.openSession(true);//这个才是真正帮助我们实现功能的对象

        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);

        List<Integer> ids = new ArrayList<>();
        ids.add(6);
        ids.add(4);
        ids.add(5);
//        ids.add(2);

        List<Student> list = mapper.selectByIds(ids);

        for (Student student : list) {
            System.out.println(student);
        }

        sqlSession.close();
        is.close();
    }
}
