package com.bjpowernode.springboot.controller;

import com.bjpowernode.springboot.model.User;
import org.springframework.web.bind.annotation.*;

/**
 * @Author 714班
 */
@RestController // @RestController = @Controller + @ResponseBody
public class MVCController {

    @RequestMapping(value="/boot/getUser", method = RequestMethod.GET)
    public Object getUser() {
        User user = new User();
        user.setId(100);
        user.setName("张无忌");

        return user;
    }

    /**
     * @GetMapping 只支持get请求 @GetMapping = @RequestMapping + RequestMethod.GET
     * @return
     */
    @GetMapping("/boot/getUser1")
    public Object getUser1() {
        User user = new User();
        user.setId(100);
        user.setName("张无忌");

        return user;
    }

    /**
     * @GetMapping 只支持POST请求 @PostMapping = @RequestMapping + RequestMethod.POST
     * @return
     */
    @PostMapping("/boot/getUser2")
    public Object getUser2() {
        User user = new User();
        user.setId(100);
        user.setName("张无忌-POST");

        return user;
    }
}