package com.bjpowernode.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author 714班
 */
@Controller
public class JSPController {

    @GetMapping("/boot/index")
    public String index (Model model) {

        model.addAttribute("msg", "Spring boot 集成 jsp.");

        return "index";
    }
}