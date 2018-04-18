package myoa.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Message")
public class Message {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String title;
	private String content;
	private int creatorid;
	private Date sendtime;
	private String receivers;
	private int level;
	private int status;
	private Boolean issent;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getCreatorid() {
		return creatorid;
	}
	public void setCreatorid(int creatorid) {
		this.creatorid = creatorid;
	}
	public Date getSendtime() {
		return sendtime;
	}
	public void setSendtime(Date sendtime) {
		this.sendtime = sendtime;
	}
	public String getReceivers() {
		return receivers;
	}
	public void setReceivers(String receivers) {
		this.receivers = receivers;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Boolean getIssent() {
		return issent;
	}
	public void setIssent(Boolean issent) {
		this.issent = issent;
	}
}
