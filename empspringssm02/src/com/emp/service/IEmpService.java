package com.emp.service;

import java.util.List;
import java.util.Map;

import com.emp.domain.EmpInfo;

public interface IEmpService {
	
	/**
	 * 登录功能
	 * @param loginname
	 * @param loginpwd
	 * @return
	 */
	public Map<String,Object> login(String loginname,String loginpwd);
	
	/**
	 *  查询功能
	 * @param selemp
	 * @return
	 */
	public Map<String,Object> query(EmpInfo selemp);
	
	
	/**
	 * 新增跳转
	 * @return
	 */
	public Map<String,Object> addTo();
	
	/**
	 * 新增保存
	 * @param empinfo
	 * @return
	 */
	public Map<String,Object> insert(EmpInfo empinfo);
	
	/**
	 * 修改跳转
	 * @param empno
	 * @return
	 */
	public Map<String,Object> updateTo(Integer empno);
	
	/**
	 * 修改保存
	 * @param empinfo
	 * @return
	 */
	public Map<String,Object> update(EmpInfo empinfo);
	
	/**
	 * 删除功能
	 * @param empno
	 * @return
	 */
	public Map<String,Object> delete(Integer[] empnos);
	
	
	/**
	 * 查询所有员工
	 * @return
	 */
	public List<EmpInfo> queryMgr();
}
