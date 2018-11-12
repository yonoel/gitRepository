package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**  
* @ClassName: TestController  
* @Description: TODO(这里用一句话描述这个类的作用)
* @date 2018年8月2日 下午2:27:42    
*    
*/
@Controller
public class TestController {
    @RequestMapping("/test1")  
    public String test1() {  
        return "test1";  
    }  
    
    @RequestMapping("/test2")  
    public String test2(@RequestParam Long id, @RequestParam String name, Model model) {  
        model.addAttribute("id", id);  
        model.addAttribute("name", name);  
        return "test2";  
    }  
}
