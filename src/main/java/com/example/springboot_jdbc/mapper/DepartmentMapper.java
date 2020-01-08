package com.example.springboot_jdbc.mapper;

import com.example.springboot_jdbc.bean.Department;
import org.apache.ibatis.annotations.*;

@Mapper
public interface DepartmentMapper {

    @Select("select * from Department where id=#{Id}")
    public Department getDeptID(Integer Id);
    @Delete("delete from  Department where id=#{Id}")
    public  int deleteId(Integer Id);
    @Insert("insert into department(departmentName) values(#{departmentName})")
    public  int insert(Department department);
    @Update("update department set departmentName=#{departmentName} where id=#{id} ")
    public int updateDept(Department department);



}
