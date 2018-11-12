package com.igeek.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.igeek.domain.User;

/**
 * @ClassName: UserController
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2018年8月7日 下午6:42:37
 * 
 */
@Controller
@SessionAttributes(names = "loginuser", types = User.class)
public class UserController extends BaseController {

    @PostMapping("/dolongin")
    @ResponseBody
    public Map<String, Object> longinHandler(User user, HttpSession session) {
        Map<String, Object> map = new HashMap<String, Object>();
        String message = "登陆失败";
        map.put("message", message);
        map.put("flag", false);
        if (userService.query(user)) {
            User userDTO = userService.getUserByNameAndPassword(user);
            session.setAttribute("loginuser", userDTO);
            session.setMaxInactiveInterval(60 * 60 * 2);
            message = "登录成功";
            map.put("message", message);
            map.put("flag", true);
        }
        return map;
    }

    @RequestMapping("/touser")
    public String userInfoHandler() {
        return "user";
    }

    @GetMapping("/tosubject")
    public String examHandler() {
        return "subject";
    }

    @GetMapping("/totestpaper")
    public String testpagerHandler() {
        return "testpaper";
    }

    // 测试依赖注入的 map的key是serviceimpl的beanname ，list是乱序的，需要@Order来安排位置
    @ResponseBody
    @RequestMapping("/test")
    public String testDi() {
        map.forEach((k, v) -> System.out.println("k:" + k + ",v:" + v));
        System.out.println("================");
        list.forEach(System.out::println);
        return "dependency inject";
    }
}
