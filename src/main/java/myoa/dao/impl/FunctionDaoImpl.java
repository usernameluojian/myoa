package myoa.dao.impl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import myoa.dao.FunctionDao;
import myoa.dao.MessageReceptionDao;
import myoa.entity.Function;

@Repository
public class FunctionDaoImpl implements FunctionDao{
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-beans.xml");
		FunctionDao f = ctx.getBean(FunctionDao.class);
		System.out.println(f.FunctionisNULL().size());
	}

	//查询功能表为ParentId为空的字段
	@Override
	public List<Function> FunctionisNULL() {
		// TODO Auto-generated method stub
		return (List<Function>) hibernateTemplate.find("FROM Function WHERE ParentId IS NULL AND IsMenuItem = 1");
	}

	//查询功能表为ParentId等于参数的id
	@Override
	public List<Function> FunctionParentId(int id) {
		// TODO Auto-generated method stub
		return (List<Function>) hibernateTemplate.find("FROM Function WHERE ParentId = "+id+" AND IsMenuItem = 1");
	}
}
