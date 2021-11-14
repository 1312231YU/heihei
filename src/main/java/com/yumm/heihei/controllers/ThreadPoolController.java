package com.yumm.heihei.controllers;

import com.yumm.heihei.Pojo.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Description TODO
 * @Author yumm
 * @Date 2021/9/23 22:09
 * @Version 1.0
 **/
@RestController
public class ThreadPoolController {

    @PostMapping("/threadTest")
    public String threadTest(){
        ThreadPoolExecutor threadPoolExecutor=new ThreadPoolExecutor(5, 5, 0,
                TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(3),
                new ThreadPoolExecutor.DiscardOldestPolicy());

        List<Student> list = new ArrayList<Student>();

        try{
            threadPoolExecutor.execute(()->{

                Student grade = new Student();
                list.add(grade);
                try {
                    Thread.sleep(100);
                    System.out.println("我是1");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

            System.out.println(threadPoolExecutor.getActiveCount());

            threadPoolExecutor.execute(()->{
                Student grade = new Student();
                list.add(grade);
                try {
                    Thread.sleep(50);
                    System.out.println("我是2");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            System.out.println(threadPoolExecutor.getActiveCount());
            threadPoolExecutor.execute(()->{
                Student grade = new Student();
                list.add(grade);
                try {
                    Thread.sleep(30);
                    System.out.println("我是3");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            System.out.println(threadPoolExecutor.getActiveCount());
            threadPoolExecutor.execute(()->{
                Student grade = new Student();
                list.add(grade);
                try {
                    Thread.sleep(100);
                    System.out.println("我是4");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

            System.out.println(threadPoolExecutor.getActiveCount());
            threadPoolExecutor.execute(()->{
                boolean flag = true;
                while(flag)
                {
                    try {
                        Student grade = new Student();
                        Random random=new Random();
                        int i=random.nextInt(10);
                        System.out.println("i="+i);
                        if(i>0)
                        {
                            System.out.println(2);
                        }
                        else
                        {
                            System.out.println(2/0);
                        }
                        Thread.sleep(60);
                        System.out.println("我是5");
                        flag = false;
                        list.add(grade);

                    }catch (Exception exx) {
                        exx.printStackTrace();
                    }
                }

            });
            while (true){
                if(threadPoolExecutor.getActiveCount()==0) {
                    threadPoolExecutor.shutdownNow();
                    break;
                }
            }
            System.out.println(threadPoolExecutor.getCompletedTaskCount());
            System.out.println(threadPoolExecutor.getActiveCount());
        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println(list.size());

        return "结束了";
    }

}
