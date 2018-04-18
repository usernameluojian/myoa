package myoa.dao;

import java.util.List;

import myoa.entity.Activityactor;

public interface ActivityactorDao {
	public void Add(Activityactor entity);
	
	public List<Activityactor> findActivityId(int ActivityId);
}
