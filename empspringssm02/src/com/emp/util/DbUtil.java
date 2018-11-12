package com.emp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.commons.dbutils.DbUtils;

public class DbUtil {
	public static Connection getConnection(){
		Connection conn = null;
		try {
			//1、注册驱动
			DbUtils.loadDriver("oracle.jdbc.driver.OracleDriver");
			//2、连接数据库
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:java63", "scott", "niit");
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("连接失败");
		}
		return conn;
	}
	
	public static Connection getDataSource(){
		Connection conn = null;
		try {
			//初始化命名空间 访问tomcat中conf中context.xml的配置文件中的Context标签
			Context context = new InitialContext();
			//获取数据源                                                                                           //java:/comp/env/固定格式          jdbc/oracleds为tomcat中conf中context.xml中的Resource标签中的name属性名称  name="jdbc/oracleds"
			//DataSource ds = (DataSource) context.lookup("java:/comp/env/jdbc/oracleds");
			DataSource ds = (DataSource) context.lookup("java:/comp/env/abc");
			//通过数据源获取connection
			conn = ds.getConnection();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return conn;
	}
	
	public static void close(Connection conn){
		//关闭资源
		try {
			DbUtils.close(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
