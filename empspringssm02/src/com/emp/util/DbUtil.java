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
			//1��ע������
			DbUtils.loadDriver("oracle.jdbc.driver.OracleDriver");
			//2���������ݿ�
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:java63", "scott", "niit");
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("����ʧ��");
		}
		return conn;
	}
	
	public static Connection getDataSource(){
		Connection conn = null;
		try {
			//��ʼ�������ռ� ����tomcat��conf��context.xml�������ļ��е�Context��ǩ
			Context context = new InitialContext();
			//��ȡ����Դ                                                                                           //java:/comp/env/�̶���ʽ          jdbc/oracledsΪtomcat��conf��context.xml�е�Resource��ǩ�е�name��������  name="jdbc/oracleds"
			//DataSource ds = (DataSource) context.lookup("java:/comp/env/jdbc/oracleds");
			DataSource ds = (DataSource) context.lookup("java:/comp/env/abc");
			//ͨ������Դ��ȡconnection
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
		//�ر���Դ
		try {
			DbUtils.close(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
