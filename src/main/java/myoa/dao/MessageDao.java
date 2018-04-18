package myoa.dao;

import java.util.List;

import myoa.entity.Message;

public interface MessageDao {
	public List<Message> findReceiverId(int ReceiverId);
	
	public List<Message> findIsRead(int IsRead);
	
	public List<Message> findDuplicate(int IsRead);
	
	public void Add(Message entity);
	
	public Message findId(int id);
}
