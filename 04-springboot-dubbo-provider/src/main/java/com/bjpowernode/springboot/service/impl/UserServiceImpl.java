package com.bjpowernode.springboot.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.bjpowernode.springboot.mapper.StudentMapper;
import com.bjpowernode.springboot.model.Student;
import com.bjpowernode.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author 714班
 */
@Component
@Service(version = "1.0.0", timeout = 10000) //dubbo注解 <dubbo:service interface=... ref= version=>
public class UserServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public String sayHi(String name) {
        return "Hi, SpringBoot : " + name;
    }

    @Override
    public Student getStudent(int id) {
        //查询数据库
        return studentMapper.selectByPrimaryKey(id);
    }
}