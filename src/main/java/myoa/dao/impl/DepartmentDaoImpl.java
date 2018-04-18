package myoa.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import myoa.dao.ActivityDao;
import myoa.dao.DepartmentDao;
import myoa.entity.Department;

@Repository
public class DepartmentDaoImpl implements DepartmentDao {
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	//查询所有的部位
	public List<Department> findAll(){
		return (List<Department>) hibernateTemplate.find("from Department");
	}
	
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-beans.xml");
		DepartmentDao a = ctx.getBean(DepartmentDao.class);
		System.out.println(a.findAll().size());
	}
}
