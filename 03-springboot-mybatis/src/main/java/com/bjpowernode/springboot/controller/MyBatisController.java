package com.bjpowernode.springboot.controller;

import com.bjpowernode.springboot.service.StudentSertvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author 714班
 */
@RestController
public class MyBatisController {

    @Autowired
    private StudentSertvice studentSertvice;

    @GetMapping("/boot/students")
    public Object students () {

        //线程，该线程调用底层查询所有学生的方法
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                studentSertvice.getAllStudent();
            }
        };

        //多线程测试一下缓存穿透问题
        ExecutorService executorService = Executors.newFixedThreadPool(25);
        for (int i=0; i<10000; i++) {
            executorService.submit(runnable);
        }

        return studentSertvice.getAllStudent();
    }

    @GetMapping("/boot/update")
    public Object update () {
        return studentSertvice.update();
    }
}