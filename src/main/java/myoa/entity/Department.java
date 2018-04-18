package myoa.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Department")
public class Department {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private String description;
	private int Status;
	public Department() {}
	public Department(int id, String name, String description, int status) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		Status = status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getStatus() {
		return Status;
	}
	public void setStatus(int status) {
		Status = status;
	}
}
