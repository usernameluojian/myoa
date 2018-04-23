package myoa.biz;

import java.util.List;

import myoa.entity.Message;

public interface MessageBiz {
public List<Message> findReceiverId(int id);
	
	public List<Message> findIsRead(int id);
	
	public List<Message> findDuplicate(int id);
}
