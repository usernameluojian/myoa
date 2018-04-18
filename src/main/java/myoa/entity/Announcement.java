package myoa.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Announcement")
public class Announcement {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String title;
	private String content;
	private int creatorid;
	private Date createtime;
	private Date lastedittime;
	private int approverid;
	private Date approvetime;
	private int status;
	public Announcement() {}
	public Announcement(int id, String title, String content, int creatorid, Date createtime, Date lastedittime,
			int approverid, Date approvetime, int status) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.creatorid = creatorid;
		this.createtime = createtime;
		this.lastedittime = lastedittime;
		this.approverid = approverid;
		this.approvetime = approvetime;
		this.status = status;
	}
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
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public Date getLastedittime() {
		return lastedittime;
	}
	public void setLastedittime(Date lastedittime) {
		this.lastedittime = lastedittime;
	}
	public int getApproverid() {
		return approverid;
	}
	public void setApproverid(int approverid) {
		this.approverid = approverid;
	}
	public Date getApprovetime() {
		return approvetime;
	}
	public void setApprovetime(Date approvetime) {
		this.approvetime = approvetime;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
}
