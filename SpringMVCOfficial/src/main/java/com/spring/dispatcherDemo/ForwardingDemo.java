package com.spring.dispatcherDemo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @ClassName: ForwardingDemo
 * @Description: 测试forward方法 因为 servlet forward
 *               调用的是getRequestDispatcher(String).for(request,response)，所以没法调用
 * @date 2018年7月9日 下午2:45:33
 * 
 */
@Controller
public class ForwardingDemo {

    // 访问index，创建一个新的元素message
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView string() {
        return new ModelAndView("message", "command", new String());
    }

    @RequestMapping(value = "/addStudent", method = RequestMethod.POST)
    public String addStudent(@ModelAttribute("SpringWeb") String message, ModelMap model) {
        model.addAttribute("message", message);
        return "forward:";
    }
}
