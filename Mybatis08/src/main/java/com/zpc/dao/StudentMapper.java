package com.zpc.dao;

import com.zpc.pojo.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentMapper {
    Student queryStudent(@Param("id") int id);
}
