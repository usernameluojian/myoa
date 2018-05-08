package myoa.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import myoa.dao.FunctionDao;
import myoa.dao.RoleDao;
import myoa.entity.Role;

@Repository
public class RoleDaoImpl implements RoleDao{
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	public List<Role> findAll() {
		return (List<Role>) hibernateTemplate.find("from Role");
	}
	
	public Role findOne(int id) {
		return (Role) hibernateTemplate.find("from Role where id = "+id+"").get(0);
	}
	
	public void update(Role entity) {
		hibernateTemplate.update(entity);
	}
	
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-beans.xml");
		RoleDao f = ctx.getBean(RoleDao.class);
		System.out.println(f.findOne(1));
	}
}
