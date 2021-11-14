package com.yumm.heihei.Mapper;

import com.yumm.heihei.Pojo.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@Mapper
public interface queryStudentInfo {

    @Select("select * from students")
    List<Student> queryAll();

    @Select("select id,name,age from students")
    List<Map<String,String>> queryIdName();
}
