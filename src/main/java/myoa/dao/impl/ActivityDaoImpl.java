package myoa.dao.impl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import myoa.dao.ActivityDao;
import myoa.dao.AnnouncementDao;
import myoa.entity.Activity;

@Repository
public class ActivityDaoImpl implements ActivityDao{
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	//添加会议
	public void Add(Activity entity) {
		hibernateTemplate.save(entity);
	}
	
	//全部会议
	public List<Activity> findAll(){
		return (List<Activity>) hibernateTemplate.find("from Activity");
	}
	//今日会议
	public List<Activity> findTime(){
		return (List<Activity>) hibernateTemplate.find("from Activity WHERE TO_DAYS(StartTime)=TO_DAYS(NOW())");
	}
	
	//个人会议
	public List<Activity> findActorId(int ActorId){
		return (List<Activity>) hibernateTemplate.find("FROM Activity WHERE Id IN (SELECT activityid FROM Activityactor WHERE ActorId = "+ActorId+")");
	}
	
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-beans.xml");
		ActivityDao a = ctx.getBean(ActivityDao.class);
		System.out.println(a.findActorId(2).size());
		
	}
}
