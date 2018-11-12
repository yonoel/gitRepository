package com.igeek.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**  
* @ClassName: UserController  
* @Description: TODO(这里用一句话描述这个类的作用)
* @date 2018年8月3日 上午9:13:59    
*    
*/
@Controller
public class UserController {
    @RequestMapping("/index")
    public String doViewIndex() {
        return "index";
    }
}
