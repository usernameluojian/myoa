package myoa.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import myoa.biz.FunctionBiz;
import myoa.dao.FunctionDao;
import myoa.entity.Function;

@Service
public class FunctionBizImpl implements FunctionBiz{

	@Autowired
	private FunctionDao fd;
	
	@Override
	public List<Function> FunctionisNULL() {
		// TODO Auto-generated method stub
		return fd.FunctionisNULL();
	}

	@Override
	public List<Function> FunctionRoleId(int RoleId) {
		// TODO Auto-generated method stub
		return fd.FunctionRoleId(RoleId);
	}

	@Override
	public Function Functioisid(int id) {
		// TODO Auto-generated method stub
		return fd.Functioisid(id);
	}

	@Override
	public List<Function> FunctionisNotNULL() {
		// TODO Auto-generated method stub
		return fd.FunctionisNotNULL();
	}

}
