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
import myoa.dao.EmployeeDao;
import myoa.entity.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	//按部门查询员工
	public List<Employee> findDepartmentId(int DepartmentId){
		return (List<Employee>) hibernateTemplate.find("from Employee where DepartmentId = "+DepartmentId+"");
		
	}
	
	//查询所有员工
	public List<Employee> findAll(){
		return (List<Employee>) hibernateTemplate.find("from Employee");
		
	}
	
	//筛选查询员工  分别为 名字，性别，部门，是否是部门部长 第几页，返回的总数
	public List<Employee> findLike(String NAME,int Gender,int DepartmentId,int IsManager,int page,int pagecount){
		return hibernateTemplate.execute(new HibernateCallback<List<Employee>>() {
			@Override
			public List<Employee> doInHibernate(Session arg0) throws HibernateException, SQLException {
				String sql = "SELECT Employee.* FROM Employee,Department WHERE Employee.DepartmentId = Department.id";
				if(NAME!="") {
					sql+=" and Employee.name = "+NAME+"";
				}
				if(Gender!=-1) {
					sql+=" and Employee.Gender = "+Gender+"";
				}
				if(DepartmentId!=-1) {
					sql+=" and Employee.DepartmentId = "+DepartmentId+"";
				}
				if(IsManager!=-1) {
					sql+=" and Employee.IsManager = "+IsManager+"";
				}
				SQLQuery sqlquery = arg0.createSQLQuery(sql);
				sqlquery.setFetchSize((page-1)*pagecount);
				sqlquery.setMaxResults(pagecount);
				sqlquery.addEntity(Employee.class);
				return sqlquery.list();
			}
		});
	}
	
	//筛选查询员工的页数  分别为 名字，性别，部门，是否是部门部长，返回的总数
	public Integer findcount(String NAME,int Gender,int DepartmentId,int IsManager,int pagecount){
		 Integer count = hibernateTemplate.execute(new HibernateCallback<Integer>() {
			@Override
			public Integer doInHibernate(Session arg0) throws HibernateException, SQLException {
				String sql = "SELECT Employee.* FROM Employee,Department WHERE Employee.DepartmentId = Department.id";
				if(NAME!="") {
					sql+=" and Employee.name = "+NAME+"";
				}
				if(Gender!=-1) {
					sql+=" and Employee.Gender = "+Gender+"";
				}
				if(DepartmentId!=-1) {
					sql+=" and Employee.DepartmentId = "+DepartmentId+"";
				}
				if(IsManager!=-1) {
					sql+=" and Employee.IsManager = "+IsManager+"";
				}
				SQLQuery sqlquery = arg0.createSQLQuery(sql);
				sqlquery.addEntity(Employee.class);
				return sqlquery.list().size();
			}
		});
		 return count%pagecount==0?count/pagecount:(count/pagecount)+1;
	}
	
	//登陆
	public Employee login(String nr,String password) {
		Employee employee = (Employee) hibernateTemplate.execute(new HibernateCallback<Employee>() {
			@Override
			public Employee doInHibernate(Session sesion) throws HibernateException, SQLException {
				return (Employee) sesion.createQuery("from Employee where nr='"+nr+"' and password='"+password+"'").uniqueResult();
			}
			
		});
		return employee;
	}
	//添加员工
	public void Add(Employee entity) {
		hibernateTemplate.save(entity);
	}
	//查看员工的员工号是不是重复
	public int findNr(String nr) {
		return hibernateTemplate.find("from Employee where nr='"+nr+"'").size();
	}
	
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-beans.xml");
		EmployeeDao standarddao = ctx.getBean(EmployeeDao.class);
		System.out.println(standarddao.findcount("", -1, -1, 1,4));	
	}

}
