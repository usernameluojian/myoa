package myoa.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import myoa.biz.ActivityBiz;
import myoa.dao.ActivityDao;
import myoa.dao.EmployeeDao;
import myoa.entity.Activity;

@Service
public class ActivityBizImpl implements ActivityBiz{

	@Autowired
	private ActivityDao ad;
	
	@Override
	public List<Activity> findAll() {
		// TODO Auto-generated method stub
		return ad.findAll();
	}

	@Override
	public List<Activity> findTime() {
		// TODO Auto-generated method stub
		return ad.findTime();
	}

	@Override
	public List<Activity> findActorId(int ActorId) {
		// TODO Auto-generated method stub
		return ad.findActorId(ActorId);
	}

}
