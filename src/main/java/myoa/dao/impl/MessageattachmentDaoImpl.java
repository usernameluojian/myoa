package myoa.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import myoa.dao.MessageattachmentDao;
import myoa.entity.Messageattachment;

@Repository
public class MessageattachmentDaoImpl implements MessageattachmentDao {
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	//添加邮件附件
	public void Add(Messageattachment entity) {
		hibernateTemplate.save(entity);
	}
}
