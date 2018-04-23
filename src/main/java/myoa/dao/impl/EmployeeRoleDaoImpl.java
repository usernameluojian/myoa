package myoa.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import myoa.dao.EmployeeRoleDao;
import myoa.entity.EmployeeRole;

@Repository
public class EmployeeRoleDaoImpl implements EmployeeRoleDao{
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	public void save(EmployeeRole entity) {
		hibernateTemplate.save(entity);
	}
	
	public EmployeeRole findeid(int EmployeeId) {
		return (EmployeeRole) hibernateTemplate.find("from EmployeeRole where EmployeeId = "+EmployeeId+"").get(0);
	}
	
}
