package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**  
* @ClassName: TestHtmlUnit  
* @Description: TODO(这里用一句话描述这个类的作用)
* @date 2018年8月2日 上午9:06:44    
*    
*/
@Controller
public class TestHtmlUnit {
    @RequestMapping("/messages")
    public String doFormTest() { 
        return "FormTest";
    }
}
