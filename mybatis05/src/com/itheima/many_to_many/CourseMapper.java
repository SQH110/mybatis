package com.itheima.many_to_many;

import com.itheima.bean.Course;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CourseMapper {
    //根据学生id查询所选课程（条件是中间表的cid=课程表的id并且中间表的sid=传递过来的id（这个id是我们查询过的学生表和课程表有交集的学生id））
    @Select("SELECT c.id,c.name FROM stu_cr sc,course c WHERE sc.cid=c.id AND sc.sid=#{id}")
    public abstract List<Course> selectBySid(Integer id);//接收是一个List数组
}
