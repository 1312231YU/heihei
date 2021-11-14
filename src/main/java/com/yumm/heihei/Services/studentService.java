package com.yumm.heihei.Services;

import com.yumm.heihei.Pojo.Student;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


public interface studentService {

    List<Student> queryAllStudent();

    List<String> queryIdName();
}
