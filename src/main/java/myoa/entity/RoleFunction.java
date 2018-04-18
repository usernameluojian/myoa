package myoa.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="RoleFunction")
public class RoleFunction {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private int roleid;
	private int functionid;
	public RoleFunction() {}
	public RoleFunction(int id, int roleid, int functionid) {
		super();
		this.id = id;
		this.roleid = roleid;
		this.functionid = functionid;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRoleid() {
		return roleid;
	}
	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}
	public int getFunctionid() {
		return functionid;
	}
	public void setFunctionid(int functionid) {
		this.functionid = functionid;
	}
}
