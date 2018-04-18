package myoa.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import myoa.dao.ActivityactorDao;
import myoa.entity.Activityactor;


@Repository
public class ActivityactorDaoImpl implements ActivityactorDao {
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	//添加会议参与人
	public void Add(Activityactor entity) {
		hibernateTemplate.save(entity);
	}
	
	//查看会议的关系
	public List<Activityactor> findActivityId(int ActivityId){
		return (List<Activityactor>) hibernateTemplate.find("from Activityactor where ActivityId = "+ActivityId+"");
		
	}
}
