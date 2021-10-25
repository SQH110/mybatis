package com.itheima.paging;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageInterceptor;
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
 * @create 2021-04-06 13:00
 */
public class Test01 {
    @Test
    public void selectPaging() throws Exception{
        InputStream is = Resources.getResourceAsStream("MyBatisConfig.xml");

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);

        SqlSession sqlSession = sqlSessionFactory.openSession(true);//这个才是真正帮助我们实现功能的对象

        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);

        //分页助手的功能
        //第一页：3条
        PageHelper.startPage(1,3);
        //第二页：3条
//        PageHelper.startPage(2,3);
        //第三页：3条
//        PageHelper.startPage(3,3);

        List<Student> list = mapper.selectAll();

        for (Student student : list) {
            System.out.println(student);
        }

        //获取分页相关的参数
        PageInfo<Student> info = new PageInfo<>(list);
        System.out.println("总条数：" + info.getTotal());
        System.out.println("总页数：" + info.getPages());
        System.out.println("当前页：" + info.getPageNum());



        sqlSession.close();
        is.close();
    }
}
