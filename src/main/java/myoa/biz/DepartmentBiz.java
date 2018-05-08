package myoa.biz;

import java.util.List;

import myoa.entity.Department;

public interface DepartmentBiz {
	public List<Department> findAll();
	
	public List<Department> findztree();
}
