package com.bjpowernode.springboot.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.bjpowernode.springboot.mapper.UserMapper;
import com.bjpowernode.springboot.model.User;
import com.bjpowernode.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @Author 714班
 */
@Component //spring注解
@Service //dubbo注解
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public List<User> getUserByPage(Map<String, Object> paramMap) {
        return userMapper.selectUserByPage(paramMap);
    }

    @Override
    public int getUserByTotal() {
        //字符串的序列化器
        RedisSerializer redisSerializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(redisSerializer);

        //高并发条件下，此处有点问题：缓存穿透
        //查询缓存
        Integer userByTotal = (Integer) redisTemplate.opsForValue().get("userByTotal");

        //双重检测锁
        if (null == userByTotal) {
            synchronized (this) {
                //从redis获取一下
                userByTotal = (Integer) redisTemplate.opsForValue().get("userByTotal");
                if (null == userByTotal) {
                    //缓存为空，查询一遍数据库
                    userByTotal = userMapper.selectUserByTotal();
                    //把数据库查询出来的数据，放入redis中
                    redisTemplate.opsForValue().set("userByTotal", userByTotal);
                }
            }
        }
        return userByTotal;
    }

    @Override
    public User getUserById(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateUser(User user) {
        return userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public int deleteUserById(Integer id) {
        int delete = userMapper.deleteByPrimaryKey(id);
        if (delete > 0) {
            //更新缓存
            Integer userByTotal = userMapper.selectUserByTotal();
            //把数据库查询出来的数据，放入redis中
            redisTemplate.opsForValue().set("userByTotal", userByTotal);
        }
        return delete;
    }

    /**
     * 添加用户
     *
     * @return
     */
    @Override
    public int addUser(User user) {
        int add = userMapper.insertSelective(user);
        if (add > 0) {
            //更新缓存
            Integer userByTotal = userMapper.selectUserByTotal();
            //把数据库查询出来的数据，放入redis中
            redisTemplate.opsForValue().set("userByTotal", userByTotal);
        }
        return add;
    }
}
