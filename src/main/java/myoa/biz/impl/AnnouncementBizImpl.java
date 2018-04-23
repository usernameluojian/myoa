package myoa.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import myoa.biz.AnnouncementBiz;
import myoa.dao.AnnouncementDao;
import myoa.entity.Announcement;

@Service
public class AnnouncementBizImpl implements AnnouncementBiz {

	@Autowired
	private AnnouncementDao ad;
	
	@Override
	public List<Announcement> findAll() {
		// TODO Auto-generated method stub
		return ad.findAll();
	}

	@Override
	public List<Announcement> findDepartmentId(int DepartmentId) {
		// TODO Auto-generated method stub
		return ad.findDepartmentId(DepartmentId);
	}

	@Override
	public Announcement findOne(int id) {
		// TODO Auto-generated method stub
		return ad.findOne(id);
	}

}
