package com.itheima.service.impl;

import com.itheima.bean.Student;
import com.itheima.mapper.StudentMapper;

import com.itheima.service.StudentService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/*
    业务层实现类
 */
public class StudentServiceImpl implements StudentService {

    //之前这些方法的具体执行步骤写在Mapper类中，现在mapper中只有接口
    //查询全部
    @Override
    public List<Student> selectAll() {
        InputStream is = null;
        SqlSession sqlSession = null;
        List<Student> list = null;

        try {
            //1.加载核心配置文件
            is = Resources.getResourceAsStream("MyBatisConfig.xml");
            //2.获取SqlSession工厂对象
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
            //3.通过工厂对象获取SqlSession对象
            sqlSession = sqlSessionFactory.openSession(true);//自动提交
            //4.获取StudentMapper接口（持久层接口）的实现类对象（通过Mybatis动态生成）
            StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);//参数是接口类
            //等价于：StudentMapper mapper = new StudentMapperImpl();
            /*
            这里是个多态
            父类型的接口指向实现类对象
             */

            //5.通过实现类对象调用方法，接收返回的结果
            list = mapper.selectAll();


        }catch (Exception e) {

        }finally {

            //6.释放资源
            if(sqlSession != null) {
                sqlSession.close();
            }
            if(is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
        //7.返回结果
        return list;

    }

    //根据id查询
    @Override
    public Student selectById(Integer id) {
        InputStream is = null;
        SqlSession sqlSession = null;
        Student stu = null;

        try {
            //1.加载核心配置文件
            is = Resources.getResourceAsStream("MyBatisConfig.xml");
            //2.获取SqlSession工厂对象
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
            //3.通过工厂对象获取SqlSession对象
            sqlSession = sqlSessionFactory.openSession(true);
            //4.获取StudentMapper接口的实现类对象（通过Mybatis动态生成）
            StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
            //等价于：StudentMapper mapper = new StudentMapperImpl();
            /*
            这里是个多态
            父类型的接口指向实现类对象
             */

            //5.通过实现类对象调用方法，接收返回的结果
            stu = mapper.selectById(id);


        }catch (Exception e) {

        }finally {

            //6.释放资源
            if(sqlSession != null) {
                sqlSession.close();
            }
            if(is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
        //7.返回结果
        return stu;
    }

    @Override
    public Integer insert(Student stu) {
        InputStream is = null;
        SqlSession sqlSession = null;
        Integer result = null;//影响行数

        try {
            //1.加载核心配置文件
            is = Resources.getResourceAsStream("MyBatisConfig.xml");
            //2.获取SqlSession工厂对象
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
            //3.通过工厂对象获取SqlSession对象
            sqlSession = sqlSessionFactory.openSession(true);
            //4.获取StudentMapper接口的实现类对象（通过Mybatis动态生成）
            StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
            //等价于：StudentMapper mapper = new StudentMapperImpl();
            /*
            这里是个多态
            父类型的接口指向实现类对象
             */

            //5.通过实现类对象调用方法，接收返回的结果
            result = mapper.insert(stu);


        }catch (Exception e) {

        }finally {

            //6.释放资源
            if(sqlSession != null) {
                sqlSession.close();
            }
            if(is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
        //7.返回结果
        return result;
    }

    @Override
    public Integer update(Student stu) {
        InputStream is = null;
        SqlSession sqlSession = null;
        Integer result = null;

        try {
            //1.加载核心配置文件
            is = Resources.getResourceAsStream("MyBatisConfig.xml");
            //2.获取SqlSession工厂对象
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
            //3.通过工厂对象获取SqlSession对象
            sqlSession = sqlSessionFactory.openSession(true);
            //4.获取StudentMapper接口的实现类对象（通过Mybatis动态生成）
            StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
            //等价于：StudentMapper mapper = new StudentMapperImpl();
            /*
            这里是个多态
            父类型的接口指向实现类对象
             */

            //5.通过实现类对象调用方法，接收返回的结果
            result = mapper.update(stu);


        }catch (Exception e) {

        }finally {

            //6.释放资源
            if(sqlSession != null) {
                sqlSession.close();
            }
            if(is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
        //7.返回结果
        return result;
    }

    @Override
    public Integer delete(Integer id) {
        InputStream is = null;
        SqlSession sqlSession = null;
        Integer result = null;

        try {
            //1.加载核心配置文件
            is = Resources.getResourceAsStream("MyBatisConfig.xml");
            //2.获取SqlSession工厂对象
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
            //3.通过工厂对象获取SqlSession对象
            sqlSession = sqlSessionFactory.openSession(true);
            //4.获取StudentMapper接口的实现类对象（通过Mybatis动态生成）
            StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
            //等价于：StudentMapper mapper = new StudentMapperImpl();
            /*
            这里是个多态
            父类型的接口指向实现类对象
             */

            //5.通过实现类对象调用方法，接收返回的结果
            result = mapper.delete(id);


        }catch (Exception e) {

        }finally {

            //6.释放资源
            if(sqlSession != null) {
                sqlSession.close();
            }
            if(is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
        //7.返回结果
        return result;
    }
}
