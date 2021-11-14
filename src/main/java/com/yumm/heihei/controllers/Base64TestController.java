package com.yumm.heihei.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import sun.misc.BASE64Encoder;

import java.util.Base64;

/**
 * @Description 测试base64
 * @Author yumm
 * @Date 2021/9/14 21:13
 * @Version 1.0
 **/

@RequestMapping("/base64")
public class Base64TestController {

    public String register(String usrId,String password){
        BASE64Encoder encoder=new BASE64Encoder();
        String pas = encoder.encode(password.getBytes());


        return null;
    }

}
