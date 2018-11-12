package com.igeek.mvc.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: TestRestFulController
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2018年8月6日 下午2:10:35
 * 
 */
@RestController
public class TestRestFulController {
    @RequestMapping("/restful/{id}")
    public String testRestful(@PathVariable String id) {
        return "Restful" + id;
    }
}
