package myoa.dao.impl;

import java.sql.SQLException;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import myoa.dao.MessageattachmentDao;
import myoa.entity.Employee;
import myoa.entity.Messageattachment;

@Repository
public class MessageattachmentDaoImpl implements MessageattachmentDao {
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	//添加邮件附件
	public void Add(Messageattachment entity) {
		hibernateTemplate.save(entity);
	}
	
	//查找邮件
	public Messageattachment findMessgeaid(int id) {
		return hibernateTemplate.execute(new HibernateCallback<Messageattachment>() {

			@Override
			public Messageattachment doInHibernate(Session session) throws HibernateException, SQLException {
				SQLQuery sqlquery = session.createSQLQuery("SELECT `messageattachment`.* FROM `message`,`messageattachment` WHERE `messageattachment`.`MessageId`=`message`.id AND `message`.id = "+id+"");
				sqlquery.addEntity(Messageattachment.class);
				return (Messageattachment) sqlquery.uniqueResult();
			}
		});
		
	}
}
