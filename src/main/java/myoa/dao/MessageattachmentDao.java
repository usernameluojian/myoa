package myoa.dao;

import myoa.entity.Messageattachment;

public interface MessageattachmentDao {
	public void Add(Messageattachment entity);
	
	public Messageattachment findMessgeaid(int id);
}
