package myoa.biz.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import myoa.biz.RoleFunctionBiz;
import myoa.dao.RoleFunctionDao;
import myoa.entity.RoleFunction;

@Service
public class RoleFunctionBizImpl implements RoleFunctionBiz {

	@Autowired
	private RoleFunctionDao rd;
	
	@Override
	public RoleFunction findone(int id) {
		// TODO Auto-generated method stub
		return rd.findone(id);
	}

	@Override
	public void add(RoleFunction entity) {
		// TODO Auto-generated method stub
		rd.add(entity);
	}

	@Override
	public void delete(RoleFunction entity) {
		// TODO Auto-generated method stub
		rd.delete(entity);
	}

	@Override
	public RoleFunction findFunctionIdANDroleid(int FunctionId, int roleid) {
		// TODO Auto-generated method stub
		return rd.findFunctionIdANDroleid(FunctionId, roleid);
	}

}
