package myoa.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import myoa.biz.RoleBiz;
import myoa.dao.RoleDao;
import myoa.entity.Role;

@Service
public class RoleBizImpl implements RoleBiz{

	@Autowired
	private RoleDao rd;
	
	@Override
	public List<Role> findAll() {
		// TODO Auto-generated method stub
		return rd.findAll();
	}

	@Override
	public Role findOne(int id) {
		// TODO Auto-generated method stub
		return rd.findOne(id);
	}

	@Override
	public void update(Role entity) {
		// TODO Auto-generated method stub
		rd.update(entity);
	}

}
