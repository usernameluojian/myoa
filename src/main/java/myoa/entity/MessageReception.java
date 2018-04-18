package myoa.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="MessageReception")
public class MessageReception {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private int messageid;
	private int receiverid;
	private Boolean isread;
	private int status;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getMessageid() {
		return messageid;
	}
	public void setMessageid(int messageid) {
		this.messageid = messageid;
	}
	public int getReceiverid() {
		return receiverid;
	}
	public void setReceiverid(int receiverid) {
		this.receiverid = receiverid;
	}
	public Boolean getIsread() {
		return isread;
	}
	public void setIsread(Boolean isread) {
		this.isread = isread;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
}
