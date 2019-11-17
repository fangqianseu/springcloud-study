package com.fq.springcloud.provider.dao;

import com.fq.springcloud.entities.Dept;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;


@Mapper
public interface DeptDao {
    String TABLE_NAME = "dept";
    String FIELD = "dept_no, dept_name, db_source";


    @Insert({"INSERT INTO " + TABLE_NAME + "(dept_name,db_source) values(#{deptName},DATABASE())"})
    @Options(useGeneratedKeys = true, keyProperty = "deptNo", keyColumn = "dept_no")
    boolean addDept(Dept deptEntity);

    Dept findById(Long id);

    @Select({"SELECT " + FIELD + " FROM " + TABLE_NAME})
    List<Dept> findAll();

}