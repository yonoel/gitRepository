package com.example.SpringBootStudy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**  
* @ClassName: UserController  
* @Description: TODO(这里用一句话描述这个类的作用)
* @date 2018年8月7日 上午9:28:52    
*    
*/
@Controller
public class UserController {
    //    访问成功，但是视图解析器解析错误。。。
    @GetMapping("/index")
    public String toIndex() {
        System.err.println(1111);
        return "main";
    }
    
    @RequestMapping("/well")
    @ResponseBody
    public String test() {
    return "welcome spring boot";
    }
}
