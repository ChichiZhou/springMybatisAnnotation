package com.hezho.utils;

// 用来定义Sql语句
public class SqlUtil {
    // 返回值必须是一个字符串
    public String insertMethod(){
        return "insert into students(studentId,studentName,gradId) values(#{studentId},#{studentName},#{gradId})";
    }

    public String updateMethod(){
        return "update students set studentName=#{studentName} where studentId=#{studentId}";
    }

    public String findAll(){
        return "select * from students";
    }

    public String deleteMethod(){
        return "delete from students where studentId=#{studentId}";
    }
}
