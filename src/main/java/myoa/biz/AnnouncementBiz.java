package myoa.biz;

import java.util.List;

import myoa.entity.Announcement;

public interface AnnouncementBiz {
	public List<Announcement> findAll();
	
	public List<Announcement> findDepartmentId(int DepartmentId);
	
	public Announcement findOne(int id);
}
