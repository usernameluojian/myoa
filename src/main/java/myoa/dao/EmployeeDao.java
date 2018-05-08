package myoa.dao;

import java.util.List;

import myoa.entity.Employee;
import myoa.entity.Message;

public interface EmployeeDao {

	Employee login(String string, String string2);

	public void Add(Employee entity);
	
	public int findNr(String nr);
	
	public List<Employee> findLike(String NAME,int Gender,int DepartmentId,int IsManager,int page,int pagecount);
	
	public Integer findcount(String NAME,int Gender,int DepartmentId,int IsManager,int pagecount);
	
	public List<Employee> findDepartmentId(int DepartmentId);

	public List<Employee> findAll();
	
	public Employee findid(int id);
}
