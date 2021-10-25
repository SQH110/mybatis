package com.itheima.mapper;

import com.itheima.bean.Student;

import java.util.List;
/*
    持久层接口（此时的mapper就是持久层代替了dao）
    不同于dao层，这里就是接口，
 */
public interface StudentMapper {
    //查询全部
    public abstract List<Student> selectAll();
    //同下面方法
//    List<Student> selectAll();

    //根据id查询
    public abstract Student selectById(Integer id);

    //新增数据
    public abstract Integer insert(Student stu);

    //修改数据
    public abstract Integer update(Student stu);

    //删除数据
    public abstract Integer delete(Integer id);
}
