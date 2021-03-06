package com.itheima.bean;

import java.util.List;

/*
这里的多表操作，只是拿查询来操作
中间表和一些外键的名称，我们都没有添加
 */
public class Course {
    private Integer id;     //主键id
    private String name;    //课程名称

    public Course() {
    }

    public Course(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
