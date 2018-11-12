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
	//@Autowired �Զ���  ����spring�����ļ���<context:component-scan base-package="com.emp.service"></context:component-scan>��
	//�Ѿ�ʵ��������EmpServiceImpl����,��EmpServiceImpl�����Զ���empService������
	@Autowired
	private IEmpService empService;
	@Autowired
	private IDeptService deptService;
	
	
	/**
	 * ������ת
	 * @param model
	 * @return
	 */
	@RequestMapping("/addto.action")  
	//  /ftl/emp/addto.action(�����ϵ�@RequestMapping��ֵ�ͷ����ϵ�@RequestMappingֵ��ϲ��ҵ�)
						//Model���� �������˽�ֵ���õ��ͻ��˵�ģ�����ݶ���
	public String addTo(Model model){
		//����service����
		Map<String,Object> resultMap = empService.addTo();
		
		//����̨�ļ������õ��ͻ���  �ȼ���request.setAttribute("mgrlist", resultMap.get("mgrlist"));
		model.addAttribute("mgrlist", resultMap.get("mgrlist"));
		model.addAttribute("deptlist", resultMap.get("deptlist"));
		model.addAttribute("methodflag", "doadd");
		//�����������ת�Ļ����봫��һ��������Ϊempinfo�Ŀյ�emp������Ҫ��<sform:form id="form1" commandName="empinfo">�е�commandName����һ��
		model.addAttribute("empinfo", new EmpInfo());
		//����������ص���string���͵Ļ���ת��
		return "addemp";
	}
	
	/**
	 * ��������
	 * @param empinfo
	 * @param response
	 */
	@RequestMapping("/doadd.action")
	/*
	 * 	@ModelAttribute("empinfo") EmpInfo empinfo
	 *  1������������Ĳ�����java��������Զ����õ�EmpInfo���󣬲���������Ҫ�������������������Ʊ���һ��
	 *     http://localhost:8080/emppro/ftl/emp/doadd.action?empno=1111&ename=����&job=java....
	 *     �൱��servlet�У�
	 *     //ȡ��ҳ�洫�ݹ����Ĳ�����װ��EmpInfo����
	 *      EmpInfo empinfo = setRequestToEmpInfo(request);
	 *  2����empinfo�������õ�model����   model.addAttribute("empinfo",empinfo)
	 *     model.addAttribute("empinfo",empinfo) ��������Ϊ@ModelAttribute("empinfo")�е���������
	 *     �൱��servlet��
	 *     //��Ϊ�����Ҫ����������Ҫ����empinfo����ҳ����
		   request.setAttribute("empinfo", empinfo);
	 */
	@ResponseBody
	public Map<String,Object> doAdd(@Validated(Add.class) @ModelAttribute("empinfo") EmpInfo empinfo,Errors errors){
		
		Map<String,Object> resultMap = new HashMap<String, Object>();
		//jsr303��֤
		if(errors.hasErrors()){
			//�����д�Ŵ�����Ϣ
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
		
		//��enjoysֵȡ�����õ�enjoy������
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
		
		//����service����
		resultMap = empService.insert(empinfo);
		//��resultMap��ֵת����json�ַ������õ�ҳ����
		return resultMap;
	}
	
	@RequestMapping("/doupdate.action")
	@ResponseBody
	public Map<String,Object> doUpdate(@Validated(Update.class) @ModelAttribute("empinfo") EmpInfo empinfo,Errors errors){
		
		Map<String,Object> resultMap = new HashMap<String, Object>();
		//jsr303��֤
		if(errors.hasErrors()){
			//�����д�Ŵ�����Ϣ
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
		
		//��enjoysֵȡ�����õ�enjoy������
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
				
		//����service����
		resultMap = empService.update(empinfo);
		//��resultMap��ֵת����json�ַ������õ�ҳ����
		return resultMap;
	}
	
	/**
	 * ��ת����ѯҳ��
	 * @param model
	 * @return
	 */
	@RequestMapping("/queryto.action")
	public String queryTo(Model model){
		//���ò����������ֵ
		model.addAttribute("deptlist", deptService.queryDept());
		//ת��
		return "empinfo";
	}
	
	/**
	 * ��ѯ��ϸ���ݵĹ���
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
		//����ҵ��㷽��
		resultMap = empService.query(selemp);
		return resultMap;
		
	}
	
	/**
	 * �޸���ת����
	 * @param empno
	 * @param model
	 * @return
	 */
	@RequestMapping("/updateto.action")
	public String updateTo(@RequestParam("empno") Integer empno,Model model){
		//����service�㷽��
		Map<String,Object> resultMap = empService.updateTo(empno);
		if((Boolean)resultMap.get("succ")){
			//������ʾ�������е���������
			model.addAttribute("empinfo", resultMap.get("empinfo"));
			//��mgrlist��deptlist���õ�addemp.jsp��
			model.addAttribute("mgrlist", resultMap.get("mgrlist"));
			model.addAttribute("deptlist", resultMap.get("deptlist"));
			//�޸ı���ı�־
			model.addAttribute("methodflag", "doupdate");
			
			return "addemp";
		}else {
			model.addAttribute("msg", resultMap.get("msg"));
			return "forward:/ftl/emp/queryto.action";
		}	
	}
	
	/**
	 * ɾ������
	 * @param empnos
	 */
	@RequestMapping("/dodelete.action")
	@ResponseBody
	public Map<String,Object> doDelete(@RequestParam("empnos") Integer[] empnos){
		//����service����
		Map<String,Object> resultMap = empService.delete(empnos);
		return resultMap;
	}
}
