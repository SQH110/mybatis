package com.itheima.sql;

import com.itheima.bean.Student;
import org.apache.ibatis.jdbc.SQL;

public class SqlTest {

    public static void main(String[] args) {

        String sql = getSql();
        System.out.println(sql);
    }

    //定义方法，获取查询student表的sql语句
    /*public static String getSql() {
        String sql = "SELECT * FROM student";
        return sql;
    }*/

    //借助sql功能类对上面的进行优化
    public static String getSql() {
        String sql = new SQL(){//匿名内部类
            {
                SELECT("*");//需要传入查询字段（列）
                FROM("student1");
            }
        }.toString();//这个.toString()是使用这个方法，将方法拼接出来的语句用字符串的形式返回


        return sql;//将匿名内部类的实例返回，权限提升
    }

}
