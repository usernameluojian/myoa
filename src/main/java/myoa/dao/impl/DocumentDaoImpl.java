package myoa.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import myoa.dao.DocumentDao;
import myoa.dao.EmployeeDao;
import myoa.entity.Document;
import myoa.entity.Employee;

@Repository
public class DocumentDaoImpl implements DocumentDao{
	@Autowired
	private HibernateTemplate hibernateTemplate;

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-beans.xml");
		DocumentDao d = ctx.getBean(DocumentDao.class);
		for (Document dd : d.getAllFolders()) {
			System.out.println(dd.getFileurl());
		}
	}

	public void save(Document entity) {
		hibernateTemplate.save(entity);
	}
	
	public void update(Document entity) {
		hibernateTemplate.update(entity);
	}
	
	public void delete(Document entity) {
		hibernateTemplate.delete(entity);
	}
	
	@Override
	public List<Document> getAllFolders() {
		// TODO Auto-generated method stub
		return hibernateTemplate.execute(new HibernateCallback<List<Document>>() {

			@Override
			public List<Document> doInHibernate(Session session) throws HibernateException, SQLException {
				SQLQuery sqlquery = session.createSQLQuery("SELECT * FROM Document");
				sqlquery.addEntity(Document.class);
				return sqlquery.list();
			}
		});
	}


	@Override
	public List<Document> getDocumentsByFolder(int folderId) {
		// TODO Auto-generated method stub
		return (List<Document>) hibernateTemplate.find("from Document where ParentId= "+folderId+"");
	}
	
	@Override
	public Document findid(int id) {
		// TODO Auto-generated method stub
		return (Document) hibernateTemplate.find("from Document where id= "+id+"").get(0);
	}
	
	@Override
	public List<Document> findlikename(int folderId,String name) {
		// TODO Auto-generated method stub
		return hibernateTemplate.execute(new HibernateCallback<List<Document>>() {

			@Override
			public List<Document> doInHibernate(Session session) throws HibernateException, SQLException {
				SQLQuery sqlquery = session.createSQLQuery("select * from Document where ParentId= "+folderId+"  and name like '%"+name+"%'");
				sqlquery.addEntity(Document.class);
				return sqlquery.list();
			}
		});
	}
}
