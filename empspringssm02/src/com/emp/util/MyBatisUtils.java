package com.emp.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtils {
	// mybatis�������ļ�
	private static String resource = "mybatis-config.xml";
	
	private static InputStream inputStream = null;
	
	private static SqlSessionFactory sqlSessionFactory = null;
	
	/*
	 * 	�����ʱ������þ�̬�����һ��
	 *  sqlSessionFactory����ֻҪ����һ�Σ�һֱ�洢���ڴ���
	 */
	static{
		try {
			// ʹ��MyBatis�ṩ��Resources�����mybatis�������ļ�����Ҳ���ع�����ӳ���ļ���
			inputStream = Resources.getResourceAsStream(resource);
			// ����sqlSession�Ĺ���
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * ����sqlsession�Ĺ������󴴽�SqlSession����SqlSession�����൱��jdbc�е�connection����
	 * Ҫ�õ�ʱ��ʹ����ö���
	 * @return
	 */
	public static SqlSession getSqlSession(){
		SqlSession session = null;
		try{
			// ������ִ��ӳ���ļ���sql��sqlSession������ԭ����Connection����  ����Ϊ��  ����Ĭ��Ϊfalse ֻ�ܲ�ѯ��
			session = sqlSessionFactory.openSession();
			return session;
		}catch(Exception e){
			e.printStackTrace();
		}
		return  null;
		
	}
	
	//����SqlSession���󣬵����Զ��ύ�ر�
	//commitflag��ֵΪfalse����Ҫ�ύ   ��ֵ֮Ϊtrue���Զ��ύ
	public static SqlSession getSqlSession(boolean commitflag){
		SqlSession session = null;
		try{
			// ������ִ��ӳ���ļ���sql��sqlSession������ԭ����Connection����
			session = sqlSessionFactory.openSession(commitflag);
			return session;
		}catch(Exception e){
			e.printStackTrace();
		}
		return  null;
		
	}
	
	/**
	 * �ر�sqlsession����
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
