package com.example.SpringBootStudy.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: RestUserController
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2018年8月7日 上午9:49:20
 * 
 */
@RestController
public class RestUserController {
    @GetMapping("/test")
    public String toTest() {
        return "test";
    }
}
