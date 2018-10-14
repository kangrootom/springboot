package com.bjpowernode.springboot.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.bjpowernode.springboot.service.StudentService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author 714班
 */
@RestController
public class StudentController {

    @Reference(version = "1.0.0") // <dubbo:reference id="" >
    private StudentService studentService;

    @RequestMapping("/boot/student")
    public Object getStudent (@RequestParam("id") Integer id) {
        return studentService.getStudent(id);
    }

    @RequestMapping("/boot/sayHi")
    public Object sayHi (@RequestParam("name") String name) {
        return studentService.sayHi(name);
    }
}