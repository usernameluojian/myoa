package myoa.biz;

import myoa.entity.RoleFunction;

public interface RoleFunctionBiz {
	public RoleFunction findone(int id);
	
	public void add(RoleFunction entity);
	
	public void delete(RoleFunction entity);
	
	public RoleFunction findFunctionIdANDroleid(int FunctionId,int roleid);
}
