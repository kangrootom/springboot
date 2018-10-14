package com.bjpowernode.springboot.service.impl;

import com.bjpowernode.springboot.mapper.StudentMapper;
import com.bjpowernode.springboot.model.Student;
import com.bjpowernode.springboot.service.StudentSertvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author 714班
 */
@Service
public class StudentSertviceImpl implements StudentSertvice {

    @Autowired
    private StudentMapper studentMapper;

    /**注入springboot自动配置好的RedisTemplate*/
    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;

    @Override
    public /*synchronized*/ List<Student> getAllStudent() {
        //字符串的序列化器
        RedisSerializer redisSerializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(redisSerializer);

        //高并发条件下，此处有点问题：缓存穿透
        //查询缓存
        List<Student> studentList = (List<Student>)redisTemplate.opsForValue().get("allStudents");

        if (null == studentList) {
            System.out.println("查询的数据库........");
            //缓存为空，查询一遍数据库
            studentList = studentMapper.selectAllStudent();
            //把数据库查询出来的数据，放入redis中
            redisTemplate.opsForValue().set("allStudents", studentList);
        } else {
            System.out.println("查询的缓存.......");
        }
        return studentList;
    }

    /*@Override
    public *//*synchronized*//* List<Student> getAllStudent() {
        //字符串的序列化器
        RedisSerializer redisSerializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(redisSerializer);

        //高并发条件下，此处有点问题：缓存穿透
        //查询缓存
        List<Student> studentList = (List<Student>)redisTemplate.opsForValue().get("allStudents");

        //双重检测锁
        if (null == studentList) {
            synchronized (this) {
                //从redis获取一下
                studentList = (List<Student>)redisTemplate.opsForValue().get("allStudents");
                if (null == studentList) {
                    System.out.println("查询的数据库........");
                    //缓存为空，查询一遍数据库
                    studentList = studentMapper.selectAllStudent();
                    //把数据库查询出来的数据，放入redis中
                    redisTemplate.opsForValue().set("allStudents", studentList);
                } else {
                    System.out.println("查询的缓存.......");
                }
            }
        } else {
            System.out.println("查询的缓存.......");
        }
        return studentList;
    }*/

    //@Transactional
    @Override
    public int update() {
        Student student = new Student();
        student.setId(1);
        student.setName("李四-update");
        student.setAge(18);
        int update = studentMapper.updateByPrimaryKeySelective(student);
        System.out.println("更新结果：" + update);

        //除数不能为0，所以此处会抛出一个运行时的异常，上一步的更新就会回滚
        int a = 10 / 0;

        return update;
    }
}