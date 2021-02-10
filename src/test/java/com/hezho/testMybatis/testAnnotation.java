package com.hezho.testMybatis;

import com.hezho.bean.Student;
import com.hezho.dao.StudentDao;
import com.hezho.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class testAnnotation {
    @Test
    public void testAnnotationAdd(){
        SqlSession session = SqlSessionUtil.getSession();
        StudentDao studentDao = session.getMapper(StudentDao.class);
        // test insert
        Student student1 = new Student(7,"chichizhou",3);
        studentDao.insertStu(student1);
        // 增删改的时候，一定要记得使用 session.commit() !!!!!!!!!!!!!!!!!
        session.commit();

        SqlSessionUtil.closeSession();
    }

    @Test
    public void testAnnotationUpdate(){
        SqlSession session = SqlSessionUtil.getSession();
        StudentDao studentDao = session.getMapper(StudentDao.class);
        // update insert
        Student student1 = new Student(7,"zhouhe",3);
        studentDao.updateStu(student1);
        // 增删改的时候，一定要记得使用 session.commit() !!!!!!!!!!!!!!!!!
        session.commit();

        SqlSessionUtil.closeSession();
    }

    @Test
    public void testAnnotationSelect(){
        SqlSession session = SqlSessionUtil.getSession();
        StudentDao studentDao = session.getMapper(StudentDao.class);
        // test insert
        List<Student> studentList = studentDao.findAll();
        for (Student student: studentList){
            System.out.println(student);
        }
        SqlSessionUtil.closeSession();
    }

    @Test
    public void testAnnotationDelete(){
        SqlSession session = SqlSessionUtil.getSession();
        StudentDao studentDao = session.getMapper(StudentDao.class);
        // test delete
        studentDao.deleteStu(4);
        // 增删改的时候，一定要记得使用 session.commit() !!!!!!!!!!!!!!!!!
        session.commit();

        SqlSessionUtil.closeSession();
    }
}
