package com.emp.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp.domain.DeptInfo;
import com.emp.mapper.DeptMapper;
import com.emp.service.IDeptService;
import com.emp.util.MyBatisUtils;

//该注解@Service 声明Service组件
@Service
public class DeptServiceImpl implements IDeptService{
	@Autowired
	private DeptMapper deptMapper;
	@Override
	public List<DeptInfo> queryDept() {
		// TODO Auto-generated method stub
		List<DeptInfo> deptlist = null;
		deptlist = deptMapper.queryDept();
		return deptlist;
	}

	
}
