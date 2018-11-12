package com.emp.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.emp.domain.EmpInfo;
import com.emp.groups.EmpGroup.Add;
import com.emp.groups.EmpGroup.Query;
import com.emp.groups.EmpGroup.Update;
import com.emp.service.IDeptService;
import com.emp.service.IEmpService;
import com.emp.service.impl.DeptServiceImpl;
import com.emp.service.impl.EmpServiceImpl;
import com.emp.util.CommonMethod;

@Controller
@RequestMapping("/ftl/emp")
public class EmpController {
	//private IEmpService empService = new EmpServiceImpl();
	//private IDeptService deptService = new DeptServiceImpl();
	//@Autowired 自动绑定  根据spring配置文件中<context:component-scan base-package="com.emp.service"></context:component-scan>，
	//已经实例化好了EmpServiceImpl对象,将EmpServiceImpl对象自动绑定empService变量上
	@Autowired
	private IEmpService empService;
	@Autowired
	private IDeptService deptService;
	
	
	/**
	 * 新增跳转
	 * @param model
	 * @return
	 */
	@RequestMapping("/addto.action")  
	//  /ftl/emp/addto.action(将类上的@RequestMapping的值和方法上的@RequestMapping值结合查找的)
						//Model对象 服务器端将值设置到客户端的模型数据对象
	public String addTo(Model model){
		//调用service方法
		Map<String,Object> resultMap = empService.addTo();
		
		//将后台的集合设置到客户端  等价于request.setAttribute("mgrlist", resultMap.get("mgrlist"));
		model.addAttribute("mgrlist", resultMap.get("mgrlist"));
		model.addAttribute("deptlist", resultMap.get("deptlist"));
		model.addAttribute("methodflag", "doadd");
		//如果是新增跳转的话必须传递一个属性名为empinfo的空的emp对象，主要跟<sform:form id="form1" commandName="empinfo">中的commandName保持一致
		model.addAttribute("empinfo", new EmpInfo());
		//如果方法返回的是string类型的话，转发
		return "addemp";
	}
	
	/**
	 * 新增保存
	 * @param empinfo
	 * @param response
	 */
	@RequestMapping("/doadd.action")
	/*
	 * 	@ModelAttribute("empinfo") EmpInfo empinfo
	 *  1、将发送请求的参数以java反射机制自动设置到EmpInfo对象，参数名称需要跟基础类对象的属性名称保持一致
	 *     http://localhost:8080/emppro/ftl/emp/doadd.action?empno=1111&ename=张三&job=java....
	 *     相当于servlet中：
	 *     //取得页面传递过来的参数封装成EmpInfo对象
	 *      EmpInfo empinfo = setRequestToEmpInfo(request);
	 *  2、将empinfo对象设置到model对象   model.addAttribute("empinfo",empinfo)
	 *     model.addAttribute("empinfo",empinfo) 属性名称为@ModelAttribute("empinfo")中的属性名称
	 *     相当于servlet中
	 *     //因为出错后，要回填数据需要设置empinfo对象到页面上
		   request.setAttribute("empinfo", empinfo);
	 */
	@ResponseBody
	public Map<String,Object> doAdd(@Validated(Add.class) @ModelAttribute("empinfo") EmpInfo empinfo,Errors errors){
		
		Map<String,Object> resultMap = new HashMap<String, Object>();
		//jsr303验证
		if(errors.hasErrors()){
			//集合中存放错误消息
			List<Map<String,Object>> errorlist =  new ArrayList<Map<String,Object>>();
			
			List<FieldError> fes = errors.getFieldErrors();
			if(fes != null && fes.size()>0){
				for(FieldError fe:fes){
					Map<String,Object> map = new HashMap<String, Object>();
					map.put("name", fe.getField());
					map.put("errormsg",fe.getDefaultMessage());
					errorlist.add(map);
				}
			}
			resultMap.put("errorlist", errorlist);
			return resultMap;
		}
		
		//将enjoys值取出设置到enjoy属性中
		String enjoy="";
		if(empinfo.getEnjoys() != null && empinfo.getEnjoys().length > 0){
			for(int i=0;i<empinfo.getEnjoys().length;i++){
				if(i == empinfo.getEnjoys().length-1){
					enjoy+=empinfo.getEnjoys()[i];
				}else {
					enjoy+=empinfo.getEnjoys()[i]+",";
				}
			}			
		}
		empinfo.setEnjoy(enjoy);
		
		//调用service方法
		resultMap = empService.insert(empinfo);
		//将resultMap的值转换成json字符串设置到页面上
		return resultMap;
	}
	
	@RequestMapping("/doupdate.action")
	@ResponseBody
	public Map<String,Object> doUpdate(@Validated(Update.class) @ModelAttribute("empinfo") EmpInfo empinfo,Errors errors){
		
		Map<String,Object> resultMap = new HashMap<String, Object>();
		//jsr303验证
		if(errors.hasErrors()){
			//集合中存放错误消息
			List<Map<String,Object>> errorlist =  new ArrayList<Map<String,Object>>();
			
			List<FieldError> fes = errors.getFieldErrors();
			if(fes != null && fes.size()>0){
				for(FieldError fe:fes){
					Map<String,Object> map = new HashMap<String, Object>();
					map.put("name", fe.getField());
					map.put("errormsg",fe.getDefaultMessage());
					errorlist.add(map);
				}
			}
			resultMap.put("errorlist", errorlist);
			return resultMap;
		}
		
		//将enjoys值取出设置到enjoy属性中
		String enjoy="";
		if(empinfo.getEnjoys() != null && empinfo.getEnjoys().length > 0){
			for(int i=0;i<empinfo.getEnjoys().length;i++){
				if(i == empinfo.getEnjoys().length-1){
					enjoy+=empinfo.getEnjoys()[i];
				}else {
					enjoy+=empinfo.getEnjoys()[i]+",";
				}
			}			
		}
		empinfo.setEnjoy(enjoy);
				
		//调用service方法
		resultMap = empService.update(empinfo);
		//将resultMap的值转换成json字符串设置到页面上
		return resultMap;
	}
	
	/**
	 * 跳转到查询页面
	 * @param model
	 * @return
	 */
	@RequestMapping("/queryto.action")
	public String queryTo(Model model){
		//设置部门下拉框的值
		model.addAttribute("deptlist", deptService.queryDept());
		//转发
		return "empinfo";
	}
	
	/**
	 * 查询明细数据的功能
	 * @param enamelike
	 * @param startlike
	 * @param endlike
	 * @param deptnolike
	 * @param pagenum
	 * @param response
	 */
	@RequestMapping("/query.action")
	@ResponseBody
	public Map<String,Object> query(@ModelAttribute("selemp") EmpInfo selemp){
		Map<String,Object> resultMap = new HashMap<String, Object>();
		//调用业务层方法
		resultMap = empService.query(selemp);
		return resultMap;
		
	}
	
	/**
	 * 修改跳转功能
	 * @param empno
	 * @param model
	 * @return
	 */
	@RequestMapping("/updateto.action")
	public String updateTo(@RequestParam("empno") Integer empno,Model model){
		//调用service层方法
		Map<String,Object> resultMap = empService.updateTo(empno);
		if((Boolean)resultMap.get("succ")){
			//最终显示在输入中的内容数据
			model.addAttribute("empinfo", resultMap.get("empinfo"));
			//将mgrlist和deptlist设置到addemp.jsp上
			model.addAttribute("mgrlist", resultMap.get("mgrlist"));
			model.addAttribute("deptlist", resultMap.get("deptlist"));
			//修改保存的标志
			model.addAttribute("methodflag", "doupdate");
			
			return "addemp";
		}else {
			model.addAttribute("msg", resultMap.get("msg"));
			return "forward:/ftl/emp/queryto.action";
		}	
	}
	
	/**
	 * 删除功能
	 * @param empnos
	 */
	@RequestMapping("/dodelete.action")
	@ResponseBody
	public Map<String,Object> doDelete(@RequestParam("empnos") Integer[] empnos){
		//调用service方法
		Map<String,Object> resultMap = empService.delete(empnos);
		return resultMap;
	}
}
