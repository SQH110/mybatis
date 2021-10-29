package com.itheima.mapper;

import com.itheima.bean.Student;
import com.itheima.sql.ReturnSql;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import java.util.List;

/**
 * 在不使用mybatis前，最简单的就是这种注解开发
 *
 */
public interface StudentMapper {
    //查询全部
    //@Select("SELECT * FROM student1")
    @SelectProvider(type = ReturnSql.class , method = "getSelectAll")//@SelectProvider：生成查询用的SQL语句注解
    //type：生成SQL语句功能类对象，method属性：指定调用方法
    public abstract List<Student> selectAll();

    //新增功能
    //@Insert("INSERT INTO student1 VALUES (#{id},#{name},#{age})")
    @InsertProvider(type = ReturnSql.class , method = "getInsert")
    public abstract Integer insert(Student stu);

    //修改功能
    //@Update("UPDATE student1 SET name=#{name},age=#{age} WHERE id=#{id}")
    @UpdateProvider(type = ReturnSql.class , method = "getUpdate")
    public abstract Integer update(Student stu);

    //删除功能
    //@Delete("DELETE FROM student1 WHERE id=#{id}")
    @DeleteProvider(type = ReturnSql.class , method = "getDelete")
    public abstract Integer delete(Integer id);
}
