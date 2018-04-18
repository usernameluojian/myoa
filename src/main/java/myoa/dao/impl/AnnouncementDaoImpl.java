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

import myoa.dao.AnnouncementDao;
import myoa.dao.DocumentDao;
import myoa.entity.Announcement;
import myoa.entity.Message;

@Repository
public class AnnouncementDaoImpl implements AnnouncementDao{
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	//查询所有的公告
	public List<Announcement> findAll(){
		return (List<Announcement>) hibernateTemplate.find("from Announcement");
	}
	
	//查询单个公告
	public Announcement findOne(int id){
		return (Announcement) hibernateTemplate.find("from Announcement where id = "+id+"").get(0);
	}
	
	//所属部门公告
	public List<Announcement> findDepartmentId(int DepartmentId){
		return hibernateTemplate.execute(new HibernateCallback<List<Announcement>>() {

			@Override
			public List<Announcement> doInHibernate(Session sesion) throws HibernateException, SQLException {
				SQLQuery sqlquery = sesion.createSQLQuery("SELECT a.* FROM Announcement a,Employee e WHERE a.`ApproverId` = e.id AND e.`DepartmentId` = "+DepartmentId+"");
				sqlquery.addEntity(Announcement.class);
				return sqlquery.list();
			}
			
		});
		
	}
	
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-beans.xml");
		AnnouncementDao a = ctx.getBean(AnnouncementDao.class);
		System.out.println(a.findDepartmentId(2).size());
	}
}
