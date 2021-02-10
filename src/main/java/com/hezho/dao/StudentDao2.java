package com.hezho.dao;

import com.hezho.bean.Student;
import com.hezho.utils.SqlUtil;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface StudentDao2 {
    @InsertProvider(type= SqlUtil.class,method="insertMethod")
    @Options(useGeneratedKeys=true,keyProperty="studentId")
    public int insertStu(Student student);

    @UpdateProvider(type= SqlUtil.class,method="updateMethod")
    public int updateStu(Student student);

    @SelectProvider(type= SqlUtil.class,method="findAll")
    public List<Student> findAll();

    @Select("select count(*) from students")
    public int totalCount();

    @DeleteProvider(type= SqlUtil.class,method="deleteMethod")
    public int deleteStu(int studentId);

    // 两表联查
    @ResultMap("com.hezho.dao.StudentDao2.result3")
    @Select("select * from students as s, grad as g where s.gradId=g.gradId")
    public List<Student> findAllStudent();

    // 直接插入参数
    @InsertProvider(type= SqlUtil.class,method="insertMethod")
    @Options(useGeneratedKeys=true,keyProperty="studentId")
    public int insertParam(@Param("studentId")int stuId, @Param("studentName")String stuName, @Param("gradId")int gradId);

}
