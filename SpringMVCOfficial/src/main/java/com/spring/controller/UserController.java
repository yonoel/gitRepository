package com.spring.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import jsr303.jsr349.Java.Bean.Validation.Second;
import jsr303.jsr349.Java.Bean.Validation.User;

/**
 * @ClassName: UserController
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2018年7月24日 下午6:36:08
 * 
 */
@Controller
public class UserController {
    @RequestMapping("/save")
    public String save(@Validated({ Second.class }) User user, BindingResult result) {
        if (result.hasErrors()) {
            return "error";
        }
        return "success";
    }
}
