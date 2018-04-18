package myoa.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import myoa.dao.DocumentDao;
import myoa.dao.EmployeeDao;
import myoa.entity.Document;

@Repository
public class DocumentDaoImpl implements DocumentDao{
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	//查询文件  运用在文件上树
	public List<Document> findParentId(int ParentId){
		return (List<Document>)hibernateTemplate.find("from Document where ParentId = "+ParentId+"");
	}
	
	
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-beans.xml");
		DocumentDao d = ctx.getBean(DocumentDao.class);
	}
}
