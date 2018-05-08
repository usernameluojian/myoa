package myoa.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import myoa.biz.DepartmentBiz;
import myoa.dao.DepartmentDao;
import myoa.dao.EmployeeDao;
import myoa.entity.Department;

@Service
public class DepartmentBizImpl implements DepartmentBiz {

	@Autowired
	private DepartmentDao dd;
	
	@Autowired
	private EmployeeDao ed;
	
	@Override
	public List<Department> findAll() {
		return dd.findAll();
	}
	
	public List<Department> findztree() {
		List<Department> list = dd.findAll();
		for (Department department : list) {
			department.setChildren(ed.findDepartmentId(department.getId()));
		}
		return list;
	}
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-beans.xml");
		DepartmentBiz standarddao = ctx.getBean(DepartmentBiz.class);
		
	}
}
