package com.emp.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtils {
	// mybatis的配置文件
	private static String resource = "mybatis-config.xml";
	
	private static InputStream inputStream = null;
	
	private static SqlSessionFactory sqlSessionFactory = null;
	
	/*
	 * 	类加载时，会调用静态代码块一次
	 *  sqlSessionFactory对象只要创建一次，一直存储在内存中
	 */
	static{
		try {
			// 使用MyBatis提供的Resources类加载mybatis的配置文件（它也加载关联的映射文件）
			inputStream = Resources.getResourceAsStream(resource);
			// 构建sqlSession的工厂
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 根据sqlsession的工厂对象创建SqlSession对象，SqlSession对象相当于jdbc中的connection对象
	 * 要用的时候就创建该对象
	 * @return
	 */
	public static SqlSession getSqlSession(){
		SqlSession session = null;
		try{
			// 创建能执行映射文件中sql的sqlSession，类似原来的Connection对象  参数为空  参数默认为false 只能查询用
			session = sqlSessionFactory.openSession();
			return session;
		}catch(Exception e){
			e.printStackTrace();
		}
		return  null;
		
	}
	
	//创建SqlSession对象，但是自动提交关闭
	//commitflag的值为false：需要提交   反之值为true：自动提交
	public static SqlSession getSqlSession(boolean commitflag){
		SqlSession session = null;
		try{
			// 创建能执行映射文件中sql的sqlSession，类似原来的Connection对象
			session = sqlSessionFactory.openSession(commitflag);
			return session;
		}catch(Exception e){
			e.printStackTrace();
		}
		return  null;
		
	}
	
	/**
	 * 关闭sqlsession对象
	 * @param session
	 */
	public static void closeSession(SqlSession session){
		try{
			if(session != null){
				session.close();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
}
