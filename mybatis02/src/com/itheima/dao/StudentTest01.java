package com.itheima.dao;

import com.itheima.bean.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 *
 *
 * @author sqh
 * @create 2021-04-05 8:26
 */
public class StudentTest01 {

    /*
    删除功能
     */
    @Test
    public void delete() throws IOException {
        //1.加载核心配置文件
        //利用mybatis提供的工具类
        InputStream is = Resources.getResourceAsStream("MyBatisConfig.xml");

        //2.获取SqlSession工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);

        //3.通过SqlSession工厂对象获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();//这个才是真正帮助我们实现功能的对象

        //4.执行映射配置文件中的sql语句，并接收结果(返回对应id的对象)

        //返回一个影响行数
        int result = sqlSession.update("StudentMapper.delete",2);//格式：namespace.id
        //单纯的执行完没有提交事物，因为我们使用了手动提交
        //查询不影响原来的数据，所以不用提交事务
        //补充操作：提交事务，完成插入
        sqlSession.commit();

        //5.处理结果
        System.out.println(result);

        //6.释放资源
        sqlSession.close();//sqlSession对象
        is.close();
    }



    /*
    修改功能
     */
    @Test
    public void update() throws IOException {
        //1.加载核心配置文件
        //利用mybatis提供的工具类
        InputStream is = Resources.getResourceAsStream("MyBatisConfig.xml");

        //2.获取SqlSession工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);

        //3.通过SqlSession工厂对象获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();//这个才是真正帮助我们实现功能的对象

        //4.执行映射配置文件中的sql语句，并接收结果(返回对应id的对象)
        //先创建需要添加的Student对象
        Student stu = new Student(5,"米老鼠",5);
        //返回一个影响行数
        int result = sqlSession.update("StudentMapper.update",stu);//格式：namespace.id
        //单纯的执行完没有提交事物，因为我们使用了手动提交
        //查询不影响原来的数据，所以不用提交事务
        //补充操作：提交事务，完成插入
        sqlSession.commit();

        //5.处理结果
        System.out.println(result);

        //6.释放资源
        sqlSession.close();//sqlSession对象
        is.close();
    }




    /*
    新增功能
     */
    @Test
    public void insert() throws IOException {
        //1.加载核心配置文件
        //利用mybatis提供的工具类
        InputStream is = Resources.getResourceAsStream("MyBatisConfig.xml");

        //2.获取SqlSession工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);

        //3.通过SqlSession工厂对象获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();//这个才是真正帮助我们实现功能的对象

        //4.执行映射配置文件中的sql语句，并接收结果(返回对应id的对象)
        //先创建需要添加的Student对象
        Student stu = new Student(6,"唐老鸭",6);
        //返回一个影响行数
        int result = sqlSession.insert("StudentMapper.insert",stu);//格式：namespace.id
        //单纯的执行完没有提交事物，因为我们使用了手动提交
        //查询不影响原来的数据，所以不用提交事务
        //补充操作：提交事务，完成插入
        sqlSession.commit();

        //5.处理结果
        System.out.println(result);

        //6.释放资源
        sqlSession.close();//sqlSession对象
        is.close();
    }



    /*
    根据id查询
     */
    @Test
    public void selectById() throws IOException {
        //1.加载核心配置文件
        //利用mybatis提供的工具类
        InputStream is = Resources.getResourceAsStream("MyBatisConfig.xml");

        //2.获取SqlSession工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);

        //3.通过SqlSession工厂对象获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();//这个才是真正帮助我们实现功能的对象

        //4.执行映射配置文件中的sql语句，并接收结果(返回对应id的对象)
        Student stu = sqlSession.selectOne("StudentMapper.selectById", 2);//格式：namespace.id

        //5.处理结果
        System.out.println(stu);

        //6.释放资源
        sqlSession.close();//sqlSession对象
        is.close();
    }



    /*
    查询全部
     */
    @Test
    public void selectAll() throws Exception{
        //1.加载核心配置文件
        //利用mybatis提供的工具类
        InputStream is = Resources.getResourceAsStream("MyBatisConfig.xml");

        //2.获取SqlSession工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);

        //3.通过SqlSession工厂对象获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();//这个才是真正帮助我们实现功能的对象

        //4.执行映射配置文件中的sql语句，并接收结果(返回一个list集合)
        List<Student> list = sqlSession.selectList("StudentMapper.selectAll");//格式：namespace.id

        //5.处理结果
        for (Student stu : list) {
            System.out.println(stu);
        }

        //6.释放资源
        sqlSession.close();//sqlSession对象
        is.close();

    }


}
