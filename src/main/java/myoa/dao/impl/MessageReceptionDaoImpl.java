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
	
	public void update(MessageReception entity) {
		hibernateTemplate.update(entity);;
	}
		
	public MessageReception findOne(int id) {
		return (MessageReception) hibernateTemplate.find("from MessageReception where id = "+id+"").get(0);
	}
	
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-beans.xml");
		MessageReceptionDao standarddao = ctx.getBean(MessageReceptionDao.class);
		System.out.println(standarddao.findMessageReceptionOne(11, 1).getMessageid());
	}

	@Override
	public MessageReception findMessageReceptionOne(int MessageId, int ReceiverId) {
		// TODO Auto-generated method stub
		return hibernateTemplate.execute(new HibernateCallback<MessageReception>() {

			@Override
			public MessageReception doInHibernate(Session session) throws HibernateException, SQLException {
				SQLQuery sqlquery = session.createSQLQuery("SELECT `messagereception`.* FROM `message`,`messagereception` WHERE `message`.`Id` = `messagereception`.`MessageId` AND `messagereception`.`MessageId` = "+MessageId+" AND `messagereception`.`ReceiverId` = "+ReceiverId+"");
				sqlquery.addEntity(MessageReception.class);
				return (MessageReception) sqlquery.uniqueResult();
			}
		});
	}
}
