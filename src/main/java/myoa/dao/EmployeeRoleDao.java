package myoa.dao;

import myoa.entity.EmployeeRole;

public interface EmployeeRoleDao {
	public void save(EmployeeRole entity);
	
	public EmployeeRole findeid(int EmployeeId);
}
