package myoa.dao;

import java.util.List;

import myoa.entity.Message;

public interface MessageDao {
	public List<Message> findReceiverId(int id);
	
	public List<Message> findIsRead(int id);
	
	public List<Message> findDuplicate(int id);
	
	public void Add(Message entity);
	
	public Message findId(int id);
}
