package com.zpc.dao;

import com.zpc.pojo.Student;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface StudentMapper {
    List<Student> getStudent();

    List<Student> getStudent2();
}

