package myoa.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="EmployeeRole")
public class EmployeeRole {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private int employeeid;
	private int roleid;
	public EmployeeRole() {}
	public EmployeeRole(int id, int employeeid, int roleid) {
		super();
		this.id = id;
		this.employeeid = employeeid;
		this.roleid = roleid;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getEmployeeid() {
		return employeeid;
	}
	public void setEmployeeid(int employeeid) {
		this.employeeid = employeeid;
	}
	public int getRoleid() {
		return roleid;
	}
	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}
}
