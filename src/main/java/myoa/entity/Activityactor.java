package myoa.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Activityactor")
public class Activityactor {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private int activityid;
	private int actorid;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getActivityid() {
		return activityid;
	}
	public void setActivityid(int activityid) {
		this.activityid = activityid;
	}
	public int getActorid() {
		return actorid;
	}
	public void setActorid(int actorid) {
		this.actorid = actorid;
	}
}
