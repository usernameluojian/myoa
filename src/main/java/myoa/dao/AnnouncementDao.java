package myoa.dao;

import java.util.List;

import myoa.entity.Announcement;

public interface AnnouncementDao {
	public List<Announcement> findAll();
	
	public List<Announcement> findDepartmentId(int DepartmentId);
	
	public Announcement findOne(int id);
}
