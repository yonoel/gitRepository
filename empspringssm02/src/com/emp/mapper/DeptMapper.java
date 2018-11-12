package com.emp.mapper;

import java.util.List;

import com.emp.domain.DeptInfo;

public interface DeptMapper {
	public List<DeptInfo> queryDept();
	
	public DeptInfo queryDeptByNo(Integer deptno);
}
