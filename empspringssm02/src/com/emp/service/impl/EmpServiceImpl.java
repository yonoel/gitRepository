package com.emp.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp.domain.DeptInfo;
import com.emp.domain.EmpInfo;
import com.emp.mapper.DeptMapper;
import com.emp.mapper.EmpMapper;
import com.emp.service.IEmpService;
import com.emp.util.MyBatisUtils;
import com.emp.util.PageInfo;

@Service
public class EmpServiceImpl implements IEmpService {
	//ʵ����dao����
	@Autowired
	private EmpMapper empMapper;
	@Autowired
	private DeptMapper deptMapper;
	/**
	 * ��¼����
	 * @param loginname
	 * @param loginpwd
	 * @return
	 */
	public Map<String, Object> login(String loginname, String loginpwd) {
		Map<String,Object> resultMap = new HashMap<String, Object>();
		String msg = null;
		boolean succ = false;
		//���ݵ�¼����ѯemp���ܲ�ѯ�������û����� �����ж�����  ������ȷ����ת��������  ������󣬱����鲻�� ���û������ڱ���
		EmpInfo empinfo = empMapper.queryEmpByLoginName(loginname,null);
		if(empinfo !=null){
			//�ж������Ƿ����
			if(loginpwd.equals(empinfo.getLoginpwd())){
				succ = true;
				msg = "��¼�ɹ�";
			}else {
				msg ="��½��������޷���½";
			}
		}else {
			msg ="���û������ڣ��޷���½";
		}
		resultMap.put("empinfo", empinfo);
		resultMap.put("msg", msg);
		resultMap.put("succ", succ);
		
		return resultMap;
	}
	
	/**
	 * ��ѯ����
	 */
	public Map<String,Object> query(EmpInfo selemp){
		Map<String,Object> resultMap = new HashMap<String, Object>();		
		//ȡ���ܼ�¼�������е�������
		int dataCount = empMapper.queryEmpCount(selemp);
		//���ʵ�ҳ��
		int pageNum = 1;
		//ȡ����Ҫ���ʵ�ҳ��
		String pn = selemp.getPagenum();
		if(pn != null && !"".equals(pn)){
			pageNum = Integer.parseInt(pn);
		}
		//ʵ������ҳ����
		PageInfo pageinfo = new PageInfo(dataCount, pageNum);
		selemp.setStartNum(pageinfo.getStartNum());
		selemp.setEndNum(pageinfo.getEndNum());
		
		List<EmpInfo> emplist = empMapper.queryEmpInfo(selemp);
		
		resultMap.put("emplist", emplist);
		resultMap.put("pageinfo", pageinfo);
			
		return resultMap;
	}

	/**
	 * ������ת
	 */
	public Map<String, Object> addTo() {
		Map<String,Object> resultMap = new HashMap<String, Object>();
		//����dao�з���
		//��ѯ����Ա����Ϣ
		List<EmpInfo> mgrlist = empMapper.queryMgr();
		//��ѯ���в�����Ϣ
		List<DeptInfo> deptlist = deptMapper.queryDept();
		resultMap.put("mgrlist", mgrlist);
		resultMap.put("deptlist", deptlist);
		return resultMap;
	}

	@Override
	public Map<String, Object> insert(EmpInfo empinfo) {
		Map<String,Object> resultMap = new HashMap<String, Object>();
		String msg = null;
		boolean succ = false;
		boolean succmgr = false;
		boolean succdept = false;
		//Ա����Ų����ظ�
		EmpInfo checkempno = empMapper.queryEmpByNo(empinfo.getEmpno());
		if(checkempno != null){
			msg = "Ա������ظ�����������";
		}else {
			//��¼���Ʋ����ظ�
			EmpInfo checkloginname = empMapper.queryEmpByLoginName(empinfo.getLoginname(),null);
			if(checkloginname != null){
				msg = "��¼�����ظ�����������";
			}else {
				
				//�����˾������룬�ж���˾����Ƿ����
				//��˾��ű������
				if(empinfo.getMgr() != null){
					EmpInfo checkmgr = empMapper.queryEmpByNo(empinfo.getMgr());
					if(checkmgr == null){
						msg = "��˾��Ų����ڣ���������";
						succmgr=true;
					}
				}
				
				if(!succmgr){
					//������ű�����룬�жϲ��ű���Ƿ����
					if(empinfo.getDeptno() != null){
						DeptInfo deptinfo = deptMapper.queryDeptByNo(empinfo.getDeptno());
						if(deptinfo == null){
							msg = "���ű�Ų����ڣ���������";
							succdept=true;
						}
					}
					
					if(!succdept){
						//����Ա����Ϣ
						int result = empMapper.insertEmp(empinfo);
						if(result == 1){
							msg = "�����ɹ�";
							succ = true;
						}else {
							msg = "����ʧ��";
						}
					}
				}
				
				
			}
		}			
		resultMap.put("succ", succ);
		resultMap.put("msg", msg);
		return resultMap;
	}

	/**
	 * �޸���ת
	 */
	public Map<String, Object> updateTo(Integer empno) {
		// TODO Auto-generated method stub
		//����dao�㷽��������Ա����Ų�ѯԱ����Ϣ
		Map<String,Object> resultMap = new HashMap<String, Object>();
		String msg = null;
		boolean succ = false;
		EmpInfo empinfo = empMapper.queryEmpByNo(empno);
		if(empinfo == null){
			msg = "��Ա�����ݲ����ڣ������޸�";
		}else {
			//��enjoy��ֵת�����������õ�enjoys������
			if(empinfo.getEnjoy() != null && !"".equals(empinfo.getEnjoy())){
				String[] enjoys = empinfo.getEnjoy().split(",");
				empinfo.setEnjoys(enjoys);
			}
			succ = true;
			//��ѯ����Ա����Ϣ
			List<EmpInfo> mgrlist = empMapper.queryMgr();
			//��ѯ���в�����Ϣ
			List<DeptInfo> deptlist = deptMapper.queryDept();
			resultMap.put("mgrlist", mgrlist);
			resultMap.put("deptlist", deptlist);
			resultMap.put("empinfo", empinfo);
		}
		resultMap.put("msg", msg);
		resultMap.put("succ", succ);
		return resultMap;
	}

	/**
	 * �޸Ĺ���
	 */
	public Map<String, Object> update(EmpInfo empinfo) {
		Map<String,Object> resultMap = new HashMap<String, Object>();
		String msg = null;
		boolean succ = false;
		boolean succmgr = false;
		boolean succdept = false;
		//����Ա����Ų�ѯ
		EmpInfo checkempno = empMapper.queryEmpByNo(empinfo.getEmpno());
		if(checkempno == null){
			msg = "��Ա�����ݲ����ڣ������޸�";
		}else {
			//�жϵ�¼���Ƿ��ظ�
			EmpInfo checkloginname = empMapper.queryEmpByLoginName(empinfo.getLoginname(),empinfo.getEmpno());
			if(checkloginname != null){
				msg = "�õ�¼���ظ��������޸�";
			}else {
				//�����˾������룬�ж���˾����Ƿ����
				//������ű�����룬�жϲ��ű���Ƿ����
				//�޸�Ա����Ϣ
				//�����˾������룬�ж���˾����Ƿ����
				//��˾��ű������
				if(empinfo.getMgr() != null){
					EmpInfo checkmgr = empMapper.queryEmpByNo(empinfo.getMgr());
					if(checkmgr == null){
						msg = "��˾��Ų����ڣ���������";
					}
				}
				
				if(!succmgr){
					//������ű�����룬�жϲ��ű���Ƿ����
					if(empinfo.getDeptno() != null){
						DeptInfo deptinfo = deptMapper.queryDeptByNo(empinfo.getDeptno());
						if(deptinfo == null){
							msg = "���ű�Ų����ڣ���������";
							succdept=true;
						}
					}
					
					if(!succdept){
						//����Ա����Ϣ
						int result = empMapper.updateEmp(empinfo);
						if(result == 1){
							msg = "�޸ĳɹ�";
							succ = true;
						}else {
							msg = "�޸ĳɹ�";
						}
					}
				}
			}
		}
		
		resultMap.put("succ", succ);
		resultMap.put("msg", msg);
		return resultMap;
	}

	/**
	 * ɾ������
	 */
	public Map<String, Object> delete(Integer[] empnos) {
		// TODO Auto-generated method stub
		Map<String,Object> resultMap = new HashMap<String, Object>();
		String msg = null;
		boolean succ = false;
		int result = 0;
		if(empnos != null && empnos.length>0){
			/*for(String empno:empnos){
				Integer empnoint = CommonMethod.stringToInteger(empno);
				//����dao��������ѯԱ���Ƿ����
				EmpInfo empinfo = empMapper.queryEmpByNo(empnoint);
				if(empinfo == null){
					msg = "��Ա�����ݲ����ڣ�����ɾ��";
					break;
				}else {
					//ɾ��
					result += empMapper.deleteEmp(empnoint);
				}
			}
			
			if(result == empnos.length){
				msg ="ɾ���ɹ�";
				succ = true;
				sqlsession.commit();
			}else if(result != empnos.length && msg==null){
				msg ="ɾ��ʧ��";
				sqlsession.rollback();
			}*/
			
			//����dao��������ѯԱ���Ƿ����
			List<EmpInfo> emplist = empMapper.queryEmpByNos(empnos);
			if(emplist == null || (emplist != null && emplist.size() != empnos.length)){
				msg = "��Ա�����ݲ����ڣ�����ɾ��";
			}else{
				result = empMapper.deleteEmps(empnos);
				if(result == empnos.length){
					msg ="ɾ���ɹ�";
					succ = true;
				}else {
					msg ="ɾ��ʧ��";
				}
			}
			//����ɾ��
			
			
			
		}
		
		
		resultMap.put("succ", succ);
		resultMap.put("msg", msg);
		
		return resultMap;
	}

	@Override
	public List<EmpInfo> queryMgr() {
		// TODO Auto-generated method stub
		List<EmpInfo> mgrlist = null;
		mgrlist = empMapper.queryMgr();
		return mgrlist;
	}

}
