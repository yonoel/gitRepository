package com.emp.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.emp.service.IEmpService;
import com.emp.service.impl.EmpServiceImpl;

@Controller
public class LoginController {
	//实例化service对象
	//private IEmpService empService = new EmpServiceImpl();
	@Autowired
	private IEmpService empService;
	
	
	//跳转到登陆页面
	@RequestMapping("/tologin.action")
	public String toLogin(){
		return "login";
	}
	
	
	//登录按钮的操作
	@RequestMapping("/dologin.action")
	@ResponseBody
	public Map<String,Object> doLogin(@RequestParam("loginname") String loginname,
									  @RequestParam("loginpwd") String loginpwd,
									  HttpSession session){
		
		//调用业务层做具体的业务处理
		Map<String,Object> resultMap = empService.login(loginname, loginpwd);
		//登录成功后存储session
		if((Boolean)resultMap.get("succ")){
			session.setAttribute("sessionempinfo", resultMap.get("empinfo"));
		}
		
		return resultMap;
	}
	
	//跳转到主画面
	@RequestMapping("/tomain.action")
	public String toMain(){
		return "main";
	}
	
	
	@RequestMapping("/toexit.action")
	public String toExit(HttpSession session){
		session.removeAttribute("sessionempinfo");
		return "redirect:/index.jsp";
	}
}
