package myoa.dao;

import java.util.List;

import myoa.entity.MessageReception;

public interface MessageReceptionDao {
	public void Add(MessageReception entity);
	
	public MessageReception findMessageReceptionOne(int MessageId,int ReceiverId);
	
	public void update(MessageReception entity);
		
	public MessageReception findOne(int id);
}
