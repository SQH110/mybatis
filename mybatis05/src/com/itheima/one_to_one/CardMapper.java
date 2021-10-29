package com.itheima.one_to_one;

import com.itheima.bean.Card;
import com.itheima.bean.Person;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CardMapper {
    //查询全部
    @Select("SELECT * FROM card")//这里知识查询了card表中的数据
    @Results({ //用注解表示resultMap，这是一个数组
            @Result(column = "id",property = "id"), //id要给Card类中的id变量赋值
            @Result(column = "number",property = "number"),//同上
            @Result( //封装类变量
                    property = "p",             // 被包含对象的变量名（就是Card类中变量的名字）
                    javaType = Person.class,    // 被包含对象的实际数据类型
                    column = "pid",             // 根据查询出的card表中的pid字段来查询person表
                    /*
                        pid是"SELECT * FROM card"查出来的，
                        将pid作为参数传入com.itheima.one_to_one.PersonMapper.selectById这个方法
                        也就是执行
                        将pid作为"SELECT * FROM person WHERE id=#{id}"中的#{id}
                        的赋值，来查找对应id的人的信息
                        而最终返回一个person对象，在此方法中相当于一个单表操作
                     */

                    /*
                        one、@One 一对一固定写法
                        select属性：指定调用哪个接口中的哪个方法
                     */
                    one = @One(select = "com.itheima.one_to_one.PersonMapper.selectById")
            )
    })
    public abstract List<Card> selectAll();
}
