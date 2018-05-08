package myoa.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import myoa.dao.RoleFunctionDao;
import myoa.entity.RoleFunction;

@Repository
public class RoleFunctionDaoImpl implements RoleFunctionDao {
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	public RoleFunction findone(int id) {
		return (RoleFunction) hibernateTemplate.find("from RoleFunction where id = "+id+"").get(0);
	}
	
	public RoleFunction findFunctionIdANDroleid(int FunctionId,int roleid) {
		return (RoleFunction) hibernateTemplate.find("from RoleFunction where FunctionId = "+FunctionId+" and roleid = "+roleid+"").get(0);
	}
	
	public void add(RoleFunction entity) {
		hibernateTemplate.save(entity);
	}
	
	public void delete(RoleFunction entity) {
		hibernateTemplate.delete(entity);
	}
}
