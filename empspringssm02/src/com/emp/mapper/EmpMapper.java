package com.emp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.emp.domain.EmpInfo;
import com.emp.util.PageInfo;

public interface EmpMapper {
	/**
	 * 根据登录名查询员工数据
	 * @param loginname
	 * @return
	 */
	public EmpInfo queryEmpByLoginName(@Param("loginname") String loginname,@Param("empno") Integer empno);
	
	/**
	 * 查询功能
	 * @param selemp
	 * @return
	 */
	public List<EmpInfo> queryEmpInfo(EmpInfo selemp);
	
	/**
	 * 查询emp表总记录
	 * @param selemp
	 * @return
	 */
	public int queryEmpCount(EmpInfo selemp);
	
	
	/**
	 * 查询所有员工
	 * @return
	 */
	public List<EmpInfo> queryMgr();
	
	
	/**
	 * 根据员工编号查询员工信息
	 * @param empno
	 * @return
	 */
	public EmpInfo queryEmpByNo(Integer empno);
	
	/**
	 * 根据多个员工编号查询员工信息
	 * @param empno
	 * @return
	 */
	public List<EmpInfo> queryEmpByNos(Integer[] empnos);
	
	/**
	 * 新增员工信息
	 * @param empinfo
	 * @return
	 */
	public int insertEmp(EmpInfo empinfo);
	
	
	/**
	 * 修改员工信息
	 * @param empinfo
	 * @return
	 */
	public int updateEmp(EmpInfo empinfo);
	
	
	/**
	 * 删除员工信息
	 * @param empno
	 * @return
	 */
	public int deleteEmp(Integer empno);
	
	/**
	 * 删除员工信息
	 * @param empno
	 * @return
	 */
	public int deleteEmps(Integer[] empnos);
	
	
}
