package com.emp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.emp.domain.EmpInfo;
import com.emp.util.PageInfo;

public interface EmpMapper {
	/**
	 * ���ݵ�¼����ѯԱ������
	 * @param loginname
	 * @return
	 */
	public EmpInfo queryEmpByLoginName(@Param("loginname") String loginname,@Param("empno") Integer empno);
	
	/**
	 * ��ѯ����
	 * @param selemp
	 * @return
	 */
	public List<EmpInfo> queryEmpInfo(EmpInfo selemp);
	
	/**
	 * ��ѯemp���ܼ�¼
	 * @param selemp
	 * @return
	 */
	public int queryEmpCount(EmpInfo selemp);
	
	
	/**
	 * ��ѯ����Ա��
	 * @return
	 */
	public List<EmpInfo> queryMgr();
	
	
	/**
	 * ����Ա����Ų�ѯԱ����Ϣ
	 * @param empno
	 * @return
	 */
	public EmpInfo queryEmpByNo(Integer empno);
	
	/**
	 * ���ݶ��Ա����Ų�ѯԱ����Ϣ
	 * @param empno
	 * @return
	 */
	public List<EmpInfo> queryEmpByNos(Integer[] empnos);
	
	/**
	 * ����Ա����Ϣ
	 * @param empinfo
	 * @return
	 */
	public int insertEmp(EmpInfo empinfo);
	
	
	/**
	 * �޸�Ա����Ϣ
	 * @param empinfo
	 * @return
	 */
	public int updateEmp(EmpInfo empinfo);
	
	
	/**
	 * ɾ��Ա����Ϣ
	 * @param empno
	 * @return
	 */
	public int deleteEmp(Integer empno);
	
	/**
	 * ɾ��Ա����Ϣ
	 * @param empno
	 * @return
	 */
	public int deleteEmps(Integer[] empnos);
	
	
}
