package com.example.SpringBootStudy.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: VueController
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2018年8月20日 下午6:29:35
 * 
 */
@RestController
public class VueController {
    @GetMapping("/api")
    public String watchVue() {
        return "测试方法";
    }
}
