package com.yumm.heihei;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import sun.misc.BASE64Encoder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@SpringBootTest
class HeiheiApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    public static void test() throws IOException {
        System.out.print("�������û���:");
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String userName = in.readLine();
        System.out.print("����������:");
        String password = in.readLine();
        BASE64Encoder encoder = new BASE64Encoder();
        System.out.println("�������û���Ϊ:"
                + encoder.encode(userName.getBytes()));
        System.out.println("����������Ϊ:"
                + encoder.encode(password.getBytes()));
    }

}
