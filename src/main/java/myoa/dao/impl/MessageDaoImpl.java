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
import myoa.entity.Employee;
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
				SQLQuery sqlquery = sesion.createSQLQuery("SELECT `message`.* FROM `message`,`messagereception` WHERE `message`.`Id`=`messagereception`.`MessageId` AND `messagereception`.`ReceiverId` = "+id+" AND `message`.`IsSent` = 1 AND `messagereception`.`STATUS` = 0 AND `message`.`STATUS` = 0");
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
				SQLQuery sqlquery = sesion.createSQLQuery("SELECT `message`.* FROM `message`,`messagereception` WHERE `message`.`Id`=`messagereception`.`MessageId` AND `messagereception`.`ReceiverId` = "+id+" AND `messagereception`.`IsRead` = 1 AND `message`.`IsSent` = 1 AND `messagereception`.`STATUS` = 0 AND `message`.`STATUS` = 0");
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
		public Message finddescone(){
			return hibernateTemplate.execute(new HibernateCallback<Message>() {
				@Override
				public Message doInHibernate(Session sesion) throws HibernateException, SQLException {	
					SQLQuery sqlquery = sesion.createSQLQuery("SELECT * FROM Message ORDER BY Id DESC");
					sqlquery.setFetchSize(0);
					sqlquery.setMaxResults(1);
					sqlquery.addEntity(Message.class);
					return (Message) sqlquery.list().get(0);
				}
						
			});
		}
	//
	public List<Message> FindMulti(int ReceiverId,int page,int function){
		return hibernateTemplate.execute(new HibernateCallback<List<Message>>() {
			@Override
			public List<Message> doInHibernate(Session sesion) throws HibernateException, SQLException {	
				String sql = null;
				if(function==1) {
					sql = "SELECT `message`.* FROM `message`,`messagereception` WHERE `message`.`Id`=`messagereception`.`MessageId` AND `messagereception`.`ReceiverId` = "+ReceiverId+" AND `message`.`IsSent` = 1 AND `messagereception`.`STATUS` = 0 AND `message`.`STATUS` = 0";
				}else if(function==2) {
					sql = "SELECT `message`.* FROM `message` WHERE `message`.`CreatorId` = "+ReceiverId+" AND `message`.`IsSent` = 1 AND `message`.`STATUS` = 0";
				}else if(function==3) {
					sql = "SELECT `message`.* FROM `message` WHERE `message`.`CreatorId` = "+ReceiverId+" AND `message`.`IsSent` = 0 AND `message`.`STATUS` = 0";
				}
				SQLQuery sqlquery = sesion.createSQLQuery(sql);
				sqlquery.setFirstResult((page-1)*6);
				sqlquery.setMaxResults(6);
				sqlquery.addEntity(Message.class);
				return sqlquery.list();
			}
				
		});
	}
		public int FindMultiCount(int ReceiverId,int function){
			List<Message> list =hibernateTemplate.execute(new HibernateCallback<List<Message>>() {
				@Override
				public List<Message> doInHibernate(Session sesion) throws HibernateException, SQLException {	
					String sql = null;
					if(function==1) {
						sql = "SELECT `message`.* FROM `message`,`messagereception` WHERE `message`.`Id`=`messagereception`.`MessageId` AND `messagereception`.`ReceiverId` = "+ReceiverId+" AND `message`.`IsSent` = 1 AND `messagereception`.`STATUS` = 0 AND `message`.`STATUS` = 0";
					}else if(function==2) {
						sql = "SELECT `message`.* FROM `message` WHERE `message`.`CreatorId` = "+ReceiverId+" AND `message`.`IsSent` = 1 AND `message`.`STATUS` = 0";
					}else if(function==3) {
						sql = "SELECT `message`.* FROM `message` WHERE `message`.`CreatorId` = "+ReceiverId+" AND `message`.`IsSent` = 0 AND `message`.`STATUS` = 0";
					}
					SQLQuery sqlquery = sesion.createSQLQuery(sql);
					sqlquery.addEntity(Message.class);
					return sqlquery.list();
				}
					
			});
		return list.size();
		
	}
	//添加邮件
	public void Add(Message entity) {
		hibernateTemplate.save(entity);
	}
	
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-beans.xml");
		MessageDao d = ctx.getBean(MessageDao.class);
		
	}

	@Override
	public void update(Message entity) {
		hibernateTemplate.update(entity);
	}
}
