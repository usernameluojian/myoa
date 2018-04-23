package myoa.biz;

import java.util.List;

import myoa.entity.Activity;

public interface ActivityBiz {
	public List<Activity> findAll();
	
	public List<Activity> findTime();
	
	public List<Activity> findActorId(int ActorId);
}
