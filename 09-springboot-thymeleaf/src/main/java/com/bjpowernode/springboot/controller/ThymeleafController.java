package com.bjpowernode.springboot.controller;

import com.bjpowernode.springboot.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * @Author 714班
 */
@Controller
public class ThymeleafController {

    @RequestMapping("/boot/index")
    public String index (Model model, HttpServletRequest request) {
        //model.addAttribute("msg", "Spring Boot集成Thymeleaf.");

        User u = new User();
        u.setId(1);
        u.setNick("昵称");
        u.setPhone("13700020000");
        u.setEmail("123456@163.com");
        u.setAddress("北京大兴");
        model.addAttribute("user", u);

        List<User> userList = new ArrayList<>();
        Map<String, Object> userMap = new HashMap<>();

        User[] userArray = new User[10];
        for (int i=0; i<10; i++) {
            User user = new User();
            user.setId(i);
            user.setNick("昵称"+i);
            user.setPhone("1370002000"+i);
            user.setEmail(i+"123456@163.com");
            user.setAddress("北京大兴"+i);

            userList.add(user);
            userMap.put(String.valueOf(i), user);

            userArray[i] = user;
        }
        model.addAttribute("userList", userList);
        model.addAttribute("userMap", userMap);
        model.addAttribute("userArray", userArray);

        model.addAttribute("username", "zhangsan");

        model.addAttribute("sex", "1");

        model.addAttribute("isFlag", true);

        request.setAttribute("name", "www.bjpowernode.com");

        request.getSession().setAttribute("address", "beijing");

        model.addAttribute("date", new Date());

        model.addAttribute("str", "2018-03-05 16:05:50");

        return "index";
    }
}
