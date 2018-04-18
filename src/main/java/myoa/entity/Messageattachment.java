package myoa.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Messageattachment")
public class Messageattachment {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private String fileurl;
	private int messageid;
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
	public String getFileurl() {
		return fileurl;
	}
	public void setFileurl(String fileurl) {
		this.fileurl = fileurl;
	}
	public int getMessageid() {
		return messageid;
	}
	public void setMessageid(int messageid) {
		this.messageid = messageid;
	}
}
