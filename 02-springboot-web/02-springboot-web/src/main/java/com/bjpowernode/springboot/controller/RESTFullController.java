package com.bjpowernode.springboot.controller;

import com.bjpowernode.springboot.model.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author 714班
 */
@RestController
public class RESTFullController {

    // http://localhost:9500/02-springboot-web/boot/user/106
    @RequestMapping("/boot/user/{id}")
    public Object user (@PathVariable("id") Integer id) {

        User user = new User();
        user.setId(id);
        user.setName("张三丰");

        return user;
    }

    // http://localhost:9500/02-springboot-web/boot/user/106/zhangsan
    @RequestMapping("/boot/user/{id}/{name}")
    public Object user (@PathVariable("id") Integer id, @PathVariable("name") String name) {

        User user = new User();
        user.setId(id);
        user.setName(name);

        return user;
    }

    // http://localhost:9500/02-springboot-web/boot/zhangsan/user/106
    @RequestMapping("/boot/{name}/user/{id}")
    public Object user2 (@PathVariable("id") Integer id, @PathVariable("name") String name) {

        User user = new User();
        user.setId(id);
        user.setName(name);

        return user;
    }

    // http://localhost:9500/02-springboot-web/boot/user/106/18
    @RequestMapping("/boot/user/{id}/{age}")
    public Object user (@PathVariable("id") Integer id, @PathVariable("age") Integer age) {

        User user = new User();
        user.setId(id);
        //user.setName(name);

        return user;
    }
}
