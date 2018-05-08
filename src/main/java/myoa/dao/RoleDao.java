package myoa.dao;

import java.util.List;

import myoa.entity.Role;

public interface RoleDao {
	public List<Role> findAll();
	
	public Role findOne(int id);
	
	public void update(Role entity);
}
