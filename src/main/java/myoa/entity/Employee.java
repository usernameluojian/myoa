package myoa.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Employee")
public class Employee {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String nr;
	private String password;
	private String name;
	private Boolean gender;
	private Boolean ismanager;
	private Integer status;
	@ManyToOne
	@JoinColumn(name="departmentid")
	private Department department;
	
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNr() {
		return nr;
	}
	public void setNr(String nr) {
		this.nr = nr;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Boolean getGender() {
		return gender;
	}
	public void setGender(Boolean gender) {
		this.gender = gender;
	}
	public Boolean getIsmanager() {
		return ismanager;
	}
	public void setIsmanager(Boolean ismanager) {
		this.ismanager = ismanager;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
}
