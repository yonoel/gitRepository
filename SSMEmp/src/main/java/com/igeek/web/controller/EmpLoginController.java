package com.igeek.web.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.igeek.domain.Emp;
import com.igeek.services.IEmpServices;

/**
 * @ClassName: WebController
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2018年7月17日 上午7:06:09
 * 
 */
@Controller
@SessionAttributes(names = "account", types = Emp.class)
public class EmpLoginController {
    @Resource
    private IEmpServices services;

    
    
    @RequestMapping("/login")
    public String loginHandler(Model model) {
        model.addAttribute("command", new Emp());
        return "login";
    }

    @RequestMapping("/loginName.do")
    @ResponseBody
    public Map<String, Object> loginDo(String empName) {
        Emp emp = new Emp();
        emp.setEname(empName);
        // response.setCharacterEncoding("UTF-8");
        // System.out.println(jsonStr.toString());
        // jsonStr.append("中国");

        return services.queryEmp(emp);
    }

    @PostMapping("/dologin.action")
    public String login(Emp emp, HttpSession session, Model model) {
        Map<String, Object> map = services.queryEmp(emp);
        if ((Boolean) map.get("flag") == true) {

            // 如果成功获取对象,session域设置对象
            session.removeAttribute("account");
            session.setAttribute("account", map.get("success"));
            return "redirect:/jsp/main.jsp";
            // return "main";
        }
        // 如果失败返回信息，并且数据回显
        model.addAllAttributes(map);
        return "login";
    }

    // // 重定向的问题,一定要写这个方法才能实现重定向，已经解决，因为重定向后的路径地址不会经过过滤器，是服务器端设置的
   /* @RequestMapping("/main")
    public String toMain() {
        return "main";
    }*/
}
