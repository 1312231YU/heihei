package com.yumm.heihei.Services;

import com.yumm.heihei.Mapper.queryStudentInfo;
import com.yumm.heihei.Pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class studentServiceImp implements studentService{
    @Autowired
    private queryStudentInfo queryStudentInfo;
    @Override
    public List<Student> queryAllStudent() {
        return queryStudentInfo.queryAll();
    }

    @Override
    public List<String> queryIdName() {

        List<Map<String,String>> maps = queryStudentInfo.queryIdName();
        Map<String,String> map=new HashMap<>();

        for(Map<String,String> mm:maps){

            String name=mm.get("name");
            String id=String.valueOf(mm.get("id"));
            String age=String.valueOf(mm.get("age"));
            map.put(id,name+age);
        }
        return null;
    }
}
