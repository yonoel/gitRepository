package com.emp.service;

import java.util.List;
import java.util.Map;

import com.emp.domain.EmpInfo;

public interface IEmpService {
	
	/**
	 * ��¼����
	 * @param loginname
	 * @param loginpwd
	 * @return
	 */
	public Map<String,Object> login(String loginname,String loginpwd);
	
	/**
	 *  ��ѯ����
	 * @param selemp
	 * @return
	 */
	public Map<String,Object> query(EmpInfo selemp);
	
	
	/**
	 * ������ת
	 * @return
	 */
	public Map<String,Object> addTo();
	
	/**
	 * ��������
	 * @param empinfo
	 * @return
	 */
	public Map<String,Object> insert(EmpInfo empinfo);
	
	/**
	 * �޸���ת
	 * @param empno
	 * @return
	 */
	public Map<String,Object> updateTo(Integer empno);
	
	/**
	 * �޸ı���
	 * @param empinfo
	 * @return
	 */
	public Map<String,Object> update(EmpInfo empinfo);
	
	/**
	 * ɾ������
	 * @param empno
	 * @return
	 */
	public Map<String,Object> delete(Integer[] empnos);
	
	
	/**
	 * ��ѯ����Ա��
	 * @return
	 */
	public List<EmpInfo> queryMgr();
}
