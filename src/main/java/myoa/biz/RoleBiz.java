package myoa.biz;

import java.util.List;

import myoa.entity.Role;

public interface RoleBiz {
	public List<Role> findAll();
	
	public Role findOne(int id);
	
	public void update(Role entity);
}
