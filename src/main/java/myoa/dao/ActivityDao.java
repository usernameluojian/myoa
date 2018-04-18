package myoa.dao;

import java.util.List;

import myoa.entity.Activity;

public interface ActivityDao {
	public List<Activity> findAll();
	
	public List<Activity> findTime();
	
	public List<Activity> findActorId(int ActorId);
	
	public void Add(Activity entity);
}
