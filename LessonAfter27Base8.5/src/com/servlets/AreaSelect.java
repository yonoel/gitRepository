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
import com.services.AreaServices;

import javabean.Area;

/**
 * Servlet implementation class AreaSelect
 */
@WebServlet("/AreaSelect")
public class AreaSelect extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private AreaServices services = new AreaServices();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AreaSelect() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
       
        String message = request.getParameter("message");
        List<Area> list = null;
        String jsonStr = null;
        PrintWriter out = response.getWriter();
        if ("getProvinces".equalsIgnoreCase(message)) {
            list = services.queryProvinces();// 有值
        } else if ("getCities".equalsIgnoreCase(message)) {
            int parentId = Integer.parseInt(request.getParameter("parentid"));
            list = services.queryCities(parentId);
        }else if("getzones".equalsIgnoreCase(message)) {
            int parentId = Integer.parseInt(request.getParameter("parentid"));
            list = services.queryZones(parentId);
        }
        jsonStr = JSON.toJSONString(list);
        out.print(jsonStr);
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
