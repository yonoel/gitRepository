package com.emp.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.HttpRetryException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

public class CommonMethod {
	public static String isNull(Object object){
		if(object == null){
			return "";
		}
		return object.toString();
	}
	
	public static Integer stringToInteger(String str){
		Integer strint = null;
		if(str != null && !"".equals(str)){
			strint = Integer.parseInt(str);
		}
		return strint;
	}
	
	public static Double stringToDouble(String str){
		Double strdouble = null;
		if(str != null && !"".equals(str)){
			strdouble = Double.parseDouble(str);
		}
		return strdouble;
	}
	
	public static String dateToString(Date date,String pattern){
		String time=null;
		SimpleDateFormat sf = new SimpleDateFormat(pattern);
		if(date != null){
			time = sf.format(date);
		}
		return time;
	}
	
	public static Date stringToDate(String time,String pattern){
		Date date = null;
		try {
			SimpleDateFormat sf = new SimpleDateFormat(pattern);
			if(time != null && !"".equals(time)){
				date = sf.parse(time);
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}
	
	public static java.sql.Date dateToSqlDate(Date date){
		java.sql.Date sqldate = null;
		if(date != null){
			sqldate = new java.sql.Date(date.getTime());
		}
		return sqldate;
	}
	
	public static Timestamp dateToTimeStamp(Date date){
		Timestamp time = null;
		if(date != null){
			time = new Timestamp(date.getTime());
		}
		return time;
	}
	
	public static void objectToJson(HttpServletResponse response,Object object){
		try {
			PrintWriter out = response.getWriter();
			Gson gson = new Gson(); 
			String jsonstr = gson.toJson(object);
			out.print(jsonstr);
			out.flush();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
