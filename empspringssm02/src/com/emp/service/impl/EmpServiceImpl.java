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
	//实例化dao对象
	@Autowired
	private EmpMapper empMapper;
	@Autowired
	private DeptMapper deptMapper;
	/**
	 * 登录功能
	 * @param loginname
	 * @param loginpwd
	 * @return
	 */
	public Map<String, Object> login(String loginname, String loginpwd) {
		Map<String,Object> resultMap = new HashMap<String, Object>();
		String msg = null;
		boolean succ = false;
		//根据登录名查询emp表，能查询到，该用户存在 继续判断密码  密码正确，跳转到主画面  密码错误，报错，查不到 该用户不存在报错
		EmpInfo empinfo = empMapper.queryEmpByLoginName(loginname,null);
		if(empinfo !=null){
			//判断密码是否相等
			if(loginpwd.equals(empinfo.getLoginpwd())){
				succ = true;
				msg = "登录成功";
			}else {
				msg ="登陆密码错误，无法登陆";
			}
		}else {
			msg ="该用户不存在，无法登陆";
		}
		resultMap.put("empinfo", empinfo);
		resultMap.put("msg", msg);
		resultMap.put("succ", succ);
		
		return resultMap;
	}
	
	/**
	 * 查询功能
	 */
	public Map<String,Object> query(EmpInfo selemp){
		Map<String,Object> resultMap = new HashMap<String, Object>();		
		//取得总记录数，表中的总条数
		int dataCount = empMapper.queryEmpCount(selemp);
		//访问的页数
		int pageNum = 1;
		//取出你要访问的页面
		String pn = selemp.getPagenum();
		if(pn != null && !"".equals(pn)){
			pageNum = Integer.parseInt(pn);
		}
		//实例化分页对象
		PageInfo pageinfo = new PageInfo(dataCount, pageNum);
		selemp.setStartNum(pageinfo.getStartNum());
		selemp.setEndNum(pageinfo.getEndNum());
		
		List<EmpInfo> emplist = empMapper.queryEmpInfo(selemp);
		
		resultMap.put("emplist", emplist);
		resultMap.put("pageinfo", pageinfo);
			
		return resultMap;
	}

	/**
	 * 新增跳转
	 */
	public Map<String, Object> addTo() {
		Map<String,Object> resultMap = new HashMap<String, Object>();
		//调用dao中方法
		//查询所有员工信息
		List<EmpInfo> mgrlist = empMapper.queryMgr();
		//查询所有部门信息
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
		//员工编号不能重复
		EmpInfo checkempno = empMapper.queryEmpByNo(empinfo.getEmpno());
		if(checkempno != null){
			msg = "员工编号重复，不能新增";
		}else {
			//登录名称不能重复
			EmpInfo checkloginname = empMapper.queryEmpByLoginName(empinfo.getLoginname(),null);
			if(checkloginname != null){
				msg = "登录名称重复，不能新增";
			}else {
				
				//如果上司编号输入，判断上司编号是否存在
				//上司编号必须存在
				if(empinfo.getMgr() != null){
					EmpInfo checkmgr = empMapper.queryEmpByNo(empinfo.getMgr());
					if(checkmgr == null){
						msg = "上司编号不存在，不能新增";
						succmgr=true;
					}
				}
				
				if(!succmgr){
					//如果部门编号输入，判断部门编号是否存在
					if(empinfo.getDeptno() != null){
						DeptInfo deptinfo = deptMapper.queryDeptByNo(empinfo.getDeptno());
						if(deptinfo == null){
							msg = "部门编号不存在，不能新增";
							succdept=true;
						}
					}
					
					if(!succdept){
						//新增员工信息
						int result = empMapper.insertEmp(empinfo);
						if(result == 1){
							msg = "新增成功";
							succ = true;
						}else {
							msg = "新增失败";
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
	 * 修改跳转
	 */
	public Map<String, Object> updateTo(Integer empno) {
		// TODO Auto-generated method stub
		//调用dao层方法，根据员工编号查询员工信息
		Map<String,Object> resultMap = new HashMap<String, Object>();
		String msg = null;
		boolean succ = false;
		EmpInfo empinfo = empMapper.queryEmpByNo(empno);
		if(empinfo == null){
			msg = "该员工数据不存在，不能修改";
		}else {
			//将enjoy的值转换成数组设置到enjoys属性中
			if(empinfo.getEnjoy() != null && !"".equals(empinfo.getEnjoy())){
				String[] enjoys = empinfo.getEnjoy().split(",");
				empinfo.setEnjoys(enjoys);
			}
			succ = true;
			//查询所有员工信息
			List<EmpInfo> mgrlist = empMapper.queryMgr();
			//查询所有部门信息
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
	 * 修改功能
	 */
	public Map<String, Object> update(EmpInfo empinfo) {
		Map<String,Object> resultMap = new HashMap<String, Object>();
		String msg = null;
		boolean succ = false;
		boolean succmgr = false;
		boolean succdept = false;
		//根据员工编号查询
		EmpInfo checkempno = empMapper.queryEmpByNo(empinfo.getEmpno());
		if(checkempno == null){
			msg = "该员工数据不存在，不能修改";
		}else {
			//判断登录名是否重复
			EmpInfo checkloginname = empMapper.queryEmpByLoginName(empinfo.getLoginname(),empinfo.getEmpno());
			if(checkloginname != null){
				msg = "该登录名重复，不能修改";
			}else {
				//如果上司编号输入，判断上司编号是否存在
				//如果部门编号输入，判断部门编号是否存在
				//修改员工信息
				//如果上司编号输入，判断上司编号是否存在
				//上司编号必须存在
				if(empinfo.getMgr() != null){
					EmpInfo checkmgr = empMapper.queryEmpByNo(empinfo.getMgr());
					if(checkmgr == null){
						msg = "上司编号不存在，不能新增";
					}
				}
				
				if(!succmgr){
					//如果部门编号输入，判断部门编号是否存在
					if(empinfo.getDeptno() != null){
						DeptInfo deptinfo = deptMapper.queryDeptByNo(empinfo.getDeptno());
						if(deptinfo == null){
							msg = "部门编号不存在，不能新增";
							succdept=true;
						}
					}
					
					if(!succdept){
						//新增员工信息
						int result = empMapper.updateEmp(empinfo);
						if(result == 1){
							msg = "修改成功";
							succ = true;
						}else {
							msg = "修改成功";
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
	 * 删除功能
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
				//调用dao方法，查询员工是否存在
				EmpInfo empinfo = empMapper.queryEmpByNo(empnoint);
				if(empinfo == null){
					msg = "该员工数据不存在，不能删除";
					break;
				}else {
					//删除
					result += empMapper.deleteEmp(empnoint);
				}
			}
			
			if(result == empnos.length){
				msg ="删除成功";
				succ = true;
				sqlsession.commit();
			}else if(result != empnos.length && msg==null){
				msg ="删除失败";
				sqlsession.rollback();
			}*/
			
			//调用dao方法，查询员工是否存在
			List<EmpInfo> emplist = empMapper.queryEmpByNos(empnos);
			if(emplist == null || (emplist != null && emplist.size() != empnos.length)){
				msg = "有员工数据不存在，不能删除";
			}else{
				result = empMapper.deleteEmps(empnos);
				if(result == empnos.length){
					msg ="删除成功";
					succ = true;
				}else {
					msg ="删除失败";
				}
			}
			//整体删除
			
			
			
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
