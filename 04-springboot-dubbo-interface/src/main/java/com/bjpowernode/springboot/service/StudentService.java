package com.bjpowernode.springboot.service;

import com.bjpowernode.springboot.model.Student;

/**
 * @Author 714班
 */
public interface StudentService {

    public String sayHi (String name);

    public Student getStudent(int id);
}