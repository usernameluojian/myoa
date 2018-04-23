package myoa.biz.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import myoa.biz.EmployeeRoleBiz;
import myoa.dao.EmployeeRoleDao;
import myoa.entity.EmployeeRole;

@Service
public class EmployeeRoleBizImpl implements EmployeeRoleBiz {

	@Autowired
	private EmployeeRoleDao erd;
	
	@Override
	public void save(EmployeeRole entity) {
		// TODO Auto-generated method stub
		erd.save(entity);
	}

	@Override
	public EmployeeRole findeid(int EmployeeId) {
		// TODO Auto-generated method stub
		return erd.findeid(EmployeeId);
	}

}
