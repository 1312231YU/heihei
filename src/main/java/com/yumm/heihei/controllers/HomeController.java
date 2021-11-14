package com.yumm.heihei.controllers;

import com.yumm.heihei.Pojo.Student;
import com.yumm.heihei.Services.studentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/yumm")
public class HomeController {
    private static Logger logger= LoggerFactory.getLogger(HomeController.class);
    @Autowired
    private studentService service;


    @RequestMapping("/hello")
    public String  hello(MultipartFile file,String str){
        System.out.println(file.getOriginalFilename());

        //1.得到这个文件的扩展名
        String etc = file.getOriginalFilename().split(".")[1];
        //2.产生一个UUID
        String uuid = UUID.randomUUID().toString();
        //3.组合文件名
        String fileName = uuid+"."+etc;

        try (OutputStream outputStream=new FileOutputStream("E:\\yu\\hh.jpg")){

            byte[] bytes= file.getBytes();
            outputStream.write(bytes);

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(str);
        return "hahhh";
    }

    @GetMapping("/query")
    public List<Student> queryStudents(){
        return service.queryAllStudent();
    }

    @GetMapping("/queryIdName")
    public List<String> queryIdName(){
        return service.queryIdName();
    }
}
