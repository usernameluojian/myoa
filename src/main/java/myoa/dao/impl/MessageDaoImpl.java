package myoa.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import myoa.dao.MessageDao;
import myoa.entity.Message;
import myoa.entity.MessageReception;

@Repository
public class MessageDaoImpl implements MessageDao{
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	//查看单挑数据内容
	public Message findId(int id) {
		return (Message) hibernateTemplate.find("from Message where id = "+id+"").get(0);
		
	}
	
	//获取全部个人邮箱信息
	public List<Message> findReceiverId(int id){
		return hibernateTemplate.execute(new HibernateCallback<List<Message>>() {
			@Override
			public List<Message> doInHibernate(Session sesion) throws HibernateException, SQLException {
				SQLQuery sqlquery = sesion.createSQLQuery("SELECT mg.* FROM MessageReception mp,Message mg WHERE mp.`MessageId` = mg.`Id` AND mp.`ReceiverId` = "+id+"");
				sqlquery.addEntity(Message.class);
				return sqlquery.list();
			}
			
		});
	}
	
	//获取个人邮箱信息其中为未读的邮件
	public List<Message> findIsRead(int id){
		return hibernateTemplate.execute(new HibernateCallback<List<Message>>() {
			@Override
			public List<Message> doInHibernate(Session sesion) throws HibernateException, SQLException {	
				SQLQuery sqlquery = sesion.createSQLQuery("SELECT mg.* FROM MessageReception mp,Message mg WHERE mp.`MessageId` = mg.`Id` AND mp.`ReceiverId` = "+id+" AND mp.`IsRead`= 0");
				sqlquery.addEntity(Message.class);
				return sqlquery.list();
			}
				
		});
	}
	
	//获取个人邮箱信息其中为重复的邮件
	public List<Message> findDuplicate(int id){
		return hibernateTemplate.execute(new HibernateCallback<List<Message>>() {
			@Override
			public List<Message> doInHibernate(Session sesion) throws HibernateException, SQLException {	
				SQLQuery sqlquery = sesion.createSQLQuery("SELECT mg.* FROM MessageReception mp,Message mg WHERE mp.`MessageId` = mg.`Id` AND mp.`ReceiverId` = "+id+" AND mg.`Id` IN (SELECT `MessageId` FROM `messagereception` GROUP BY `MessageId`,`ReceiverId` HAVING COUNT(`Id`)>1) GROUP BY `MessageId`,`ReceiverId`");
				sqlquery.addEntity(Message.class);
				return sqlquery.list();
			}
					
		});
	}
	//添加邮件
	public void Add(Message entity) {
		hibernateTemplate.save(entity);
	}
	
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-beans.xml");
		MessageDao d = ctx.getBean(MessageDao.class);
		System.out.println(d.findReceiverId(4).size());
	}
}
