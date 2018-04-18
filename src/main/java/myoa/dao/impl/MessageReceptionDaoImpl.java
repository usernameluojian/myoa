package myoa.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.SQLCriterion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import myoa.dao.EmployeeDao;
import myoa.dao.MessageReceptionDao;
import myoa.entity.Document;
import myoa.entity.Employee;
import myoa.entity.MessageReception;

@Repository
public class MessageReceptionDaoImpl implements MessageReceptionDao{
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	//添加邮件接收记录表
	public void Add(MessageReception entity) {
		hibernateTemplate.save(entity);
	}
	
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-beans.xml");
		MessageReceptionDao standarddao = ctx.getBean(MessageReceptionDao.class);
	}
}
