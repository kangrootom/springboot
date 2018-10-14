package com.bjpowernode.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @Author 714班
 */
@Controller
public class SessionController {

    /**
     * 设置session
     *
     * @param sesssion
     * @return
     */
    @RequestMapping("/boot/set")
    public @ResponseBody String setSession(HttpSession sesssion) {
        sesssion.setAttribute("name", "www.bjpowernode.com");
        return "OK";
    }

    /**
     * 设置session
     *
     * @param sesssion
     * @return
     */
    @RequestMapping("/boot/get")
    public @ResponseBody String getSession(HttpSession sesssion) {
        String name = (String)sesssion.getAttribute("name");
        return name;
    }
}
