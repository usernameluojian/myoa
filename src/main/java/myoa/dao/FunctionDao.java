package myoa.dao;

import java.util.List;

import myoa.entity.Function;

public interface FunctionDao {
	public List<Function> FunctionisNULL();
	
	public List<Function> FunctionParentId(int id);
}
