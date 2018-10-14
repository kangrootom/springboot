package com.bjpowernode.springboot.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.bjpowernode.springboot.constants.Constants;
import com.bjpowernode.springboot.model.User;
import com.bjpowernode.springboot.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author 714班
 */
@Controller
public class UserController {

    /**引用远程dubbo服务*/
    @Reference
    private UserService userService;

    /**
     * 首页列表
     *
     * @param model
     * @param curPage
     * @return
     */
    @RequestMapping("/index")
    public String index (Model model,
                         @RequestParam(value="curPage", required=false) Integer curPage) {

        if (null == curPage) {
            curPage = 1;
        }

        //查总数
        int totalRows = userService.getUserByTotal();

        int totalPages = totalRows / Constants.DEFAULT_PAGESIEZE;
        int left = totalRows % Constants.DEFAULT_PAGESIEZE;
        if (left > 0) {
            totalPages = totalPages + 1;
        }

        //每次查询的起始行
        int startRow = (curPage - 1) * Constants.DEFAULT_PAGESIEZE;
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("startRow", startRow);
        paramMap.put("pageSize", Constants.DEFAULT_PAGESIEZE);
        //分页查询当前页数据
        List<User> userList = userService.getUserByPage(paramMap);

        model.addAttribute("userList", userList);

        model.addAttribute("totalPages", totalPages);
        model.addAttribute("curPage", curPage);

        return "index";
    }

    /**
     * 去修改用户
     *
     * @param model
     * @param id
     * @return
     */
    @RequestMapping("/user/toUpdate")
    public String toUpdate(Model model, @RequestParam("id") Integer id) {

        User user = userService.getUserById (id);

        model.addAttribute("user", user);
        return "user";
    }

    /**
     * 添加或修改用户
     *
     * @param user
     * @return
     */
    @RequestMapping("/user/addUser")
    public String addUser(User user) {

        if (null == user.getId()) {
            //添加操作
            userService.addUser(user);
        } else {
            //修改操作
            userService.updateUser(user);
        }
        return "redirect:/index";
    }

    /**
     * 删除用户
     *
     * @param id
     * @return
     */
    @RequestMapping("/user/delete")
    public String delete (@RequestParam("id") Integer id) {
        userService.deleteUserById(id);

        return "redirect:/index";
    }

    /**
     * 去添加用户
     *
     * @return
     */
    @RequestMapping("/user/toAddUser")
    public String toAddUser () {
        return "user";
    }
}