package com.example.SpringBootStudy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringBootStudy.domain.MyBean;
import com.example.SpringBootStudy.domain.MyBean2;

/**
 * @ClassName: MyBeanController
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2018年8月7日 下午2:43:14
 * 
 */
@RestController
public class MyBeanController {
    @Autowired
    private MyBean myBean;
    @Autowired
    private MyBean2 myBean2;
    @GetMapping("mybean")
    public String testMyBean() {
        return myBean.getName();
    }
    @GetMapping("mybean2")
    public String testMyBean2() {
        return myBean2.getMyname();
    }
}
