package myoa.biz.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import myoa.biz.EmployeeBiz;
import myoa.dao.EmployeeDao;
import myoa.entity.Employee;

@Service
public class EmployeeBizImpl implements EmployeeBiz {

	@Autowired
	private EmployeeDao ed;
	
	@Override
	public Employee login(String string, String string2) {
		// TODO Auto-generated method stub
		return ed.login(string, string2);
	}

}
