package com.hezho.dao;

import com.hezho.bean.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface StudentDao {
    @Insert("insert into students(studentId,studentName,gradId) values(#{studentId},#{studentName},#{gradId})")
    @Options(useGeneratedKeys=true,keyProperty="studentId")
    public int insertStu(Student student);

    @Update("update students set studentName=#{studentName} where studentId=#{studentId}")
    public int updateStu(Student student);

    @Select("select * from students")
    public List<Student> findAll();

    @Select("select count(*) from students")
    public int totalCount();

    @Delete("delete from students where studentId=#{studentId}")
    public int deleteStu(int studentId);

}
