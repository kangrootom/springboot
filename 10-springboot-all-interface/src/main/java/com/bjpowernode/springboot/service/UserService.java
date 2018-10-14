package com.bjpowernode.springboot.service;

import com.bjpowernode.springboot.model.User;

import java.util.List;
import java.util.Map;

/**
 * @Author 714班
 */
public interface UserService {

    /**
     * 分页的查询
     *
     * @param paramMap
     * @return
     */
    public List<User> getUserByPage(Map<String, Object> paramMap);

    /**
     * 分页的总数
     *
     * @return
     */
    public int getUserByTotal();

    /**
     * 根据用户ID查询用户信息
     *
     * @param id
     * @return
     */
    public User getUserById(Integer id);

    /**
     * 更新用户信息
     *
     * @param user
     * @return
     */
    public int updateUser(User user);

    /**
     * 根据用户ID删除用户
     *
     * @param id
     * @return
     */
    public int deleteUserById(Integer id);

    /**
     * 添加用户
     *
     * @return
     */
    public int addUser(User user);
}
