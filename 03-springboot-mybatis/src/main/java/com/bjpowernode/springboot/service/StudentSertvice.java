package com.bjpowernode.springboot.service;

import com.bjpowernode.springboot.model.Student;

import java.util.List;

/**
 * @Author 714班
 */
public interface StudentSertvice {

    public List<Student> getAllStudent();

    public int update();

}
