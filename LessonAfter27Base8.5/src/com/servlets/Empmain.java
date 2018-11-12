package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.services.EmpServices;

import javabean.Emp;

/**
 * Servlet implementation class Empmain
 */
@WebServlet("/Empmain")
public class Empmain extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        String methodflag = request.getParameter("methodflag");
        String pagenum = request.getParameter("pagenum");
        PrintWriter out = response.getWriter();
        String jsonString = null;
        int totalpage = 0;
        EmpServices services = new EmpServices();
        List<Emp> list = null;
        if (methodflag.contains("query")) {
            list = services.queryPage(pagenum);
        }
        jsonString = JSON.toJSONString(list);
        if (methodflag.equalsIgnoreCase("queryindex")) {
            // 如果第一次访问，把总页数页传递给网页
            totalpage = services.countPages();
            jsonString = jsonString.replace("[", "[{\"totalpage\":" + totalpage + "},");
        }

        out.print(jsonString);
        out.flush();
        out.close();
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
