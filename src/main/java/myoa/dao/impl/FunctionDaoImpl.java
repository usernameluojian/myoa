package myoa.dao.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
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

import myoa.dao.FunctionDao;
import myoa.dao.MessageReceptionDao;
import myoa.entity.Function;
import myoa.entity.Message;

@Repository
public class FunctionDaoImpl implements FunctionDao{
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-beans.xml");
		FunctionDao f = ctx.getBean(FunctionDao.class);
		System.out.println(f.FunctionRoleId(2).size());
	}

	public Function Functioisid(int id) {
		return (Function) hibernateTemplate.find("FROM Function WHERE id = "+id+"").get(0);
	}
	
	//查询功能表为ParentId为空的字段
	@Override
	public List<Function> FunctionisNULL() {
		// TODO Auto-generated method stub
		return (List<Function>) hibernateTemplate.find("FROM Function WHERE ParentId IS NULL AND IsMenuItem = 1");
	}
	
	public List<Function> FunctionisNotNULL() {
		// TODO Auto-generated method stub
		return (List<Function>) hibernateTemplate.find("FROM Function WHERE ParentId IS NOT NULL AND IsMenuItem = 1");
	}

	//查询功能表为ParentId等于参数的id
	@Override
	public List<Function> FunctionRoleId(int RoleId) {
		return hibernateTemplate.execute(new HibernateCallback<List<Function>>() {
			@Override
			public List<Function> doInHibernate(Session sesion) throws HibernateException, SQLException {
				SQLQuery sqlquery = sesion.createSQLQuery("SELECT f.* FROM Function f,Rolefunction r,Role e WHERE f.id = r.functionid AND r.roleid = e.id AND e.id = "+RoleId+" AND f.`ParentId` IS NOT NULL");
				sqlquery.addEntity(Function.class);
				return sqlquery.list();
			}
		});
	}
}
