package com.hezho.testMybatis;

import com.hezho.bean.Student;
import com.hezho.dao.StudentDao;
import com.hezho.dao.StudentDao2;
import com.hezho.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class testAnnotation2 {
    @Test
    public void testAnnotationAdd(){
        SqlSession session = SqlSessionUtil.getSession();
        StudentDao2 studentDao2 = session.getMapper(StudentDao2.class);
        // test insert
        Student student1 = new Student(4,"chichizhou",3);
        studentDao2.insertStu(student1);
        // 增删改的时候，一定要记得使用 session.commit() !!!!!!!!!!!!!!!!!
        session.commit();

        SqlSessionUtil.closeSession();
    }

    @Test
    public void testAnnotationSelect(){
        SqlSession session = SqlSessionUtil.getSession();
        StudentDao2 studentDao2 = session.getMapper(StudentDao2.class);
        List<Student> studentList = studentDao2.findAllStudent();

        for (Student student:studentList){
            System.out.println(student);
            System.out.println(student.getGrade());
        }

        SqlSessionUtil.closeSession();
    }

    @Test
    public void testAnnotationAddParam(){
        SqlSession session = SqlSessionUtil.getSession();
        StudentDao2 studentDao2 = session.getMapper(StudentDao2.class);
        studentDao2.insertParam(8,"zhoubin", 1);
        // 增删改 要用 commit !!!!!!!!!!!!!!!!!!!
        session.commit();
        SqlSessionUtil.closeSession();
    }
}
