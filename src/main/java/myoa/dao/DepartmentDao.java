package myoa.dao;

import java.util.List;

import myoa.entity.Department;

public interface DepartmentDao {
	public List<Department> findAll();
}
