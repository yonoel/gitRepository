package com.emp.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.emp.domain.EmpInfo;
import com.emp.util.CommonMethod;

public class LoginValidateFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("LoginValidateFilter.destroy.....");
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		// TODO Auto-generated method stub
		System.out.println("LoginValidateFilter.doFilter.....");
		HttpServletRequest request = (HttpServletRequest)arg0;
		HttpServletResponse response = (HttpServletResponse)arg1;
		//是否登录可以判断session是否存在sessionempinfo属性对应的对象
		//取得session对象
		HttpSession session = request.getSession();
		EmpInfo empinfo = (EmpInfo)session.getAttribute("sessionempinfo");
		if(empinfo != null){
			//已登录
			arg2.doFilter(arg0, arg1);
			return;
		}
		
		//查看是否为ajax请求
		String flag = request.getParameter("lvflag");
		if("ajax".equals(flag)){
			//未登录，ajax提交方式
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("loginValidateFlag", true);
			CommonMethod.objectToJson(response, map);
			return;
		}
		
		//未登录,非ajax提交方式，跳转到登陆页面
		//response.sendRedirect(request.getContextPath()+"/index.jsp");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD>");
		out.println("  <script type='text/javascript'>");
		out.println("  window.parent.location.href='"+request.getContextPath()+"/index.jsp';");
		out.println("  </script>");
		out.println("  </HEAD>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("LoginValidateFilter.init.....");
	}
	

}
