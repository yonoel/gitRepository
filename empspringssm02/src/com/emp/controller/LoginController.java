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
	//ʵ����service����
	//private IEmpService empService = new EmpServiceImpl();
	@Autowired
	private IEmpService empService;
	
	
	//��ת����½ҳ��
	@RequestMapping("/tologin.action")
	public String toLogin(){
		return "login";
	}
	
	
	//��¼��ť�Ĳ���
	@RequestMapping("/dologin.action")
	@ResponseBody
	public Map<String,Object> doLogin(@RequestParam("loginname") String loginname,
									  @RequestParam("loginpwd") String loginpwd,
									  HttpSession session){
		
		//����ҵ����������ҵ����
		Map<String,Object> resultMap = empService.login(loginname, loginpwd);
		//��¼�ɹ���洢session
		if((Boolean)resultMap.get("succ")){
			session.setAttribute("sessionempinfo", resultMap.get("empinfo"));
		}
		
		return resultMap;
	}
	
	//��ת��������
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
