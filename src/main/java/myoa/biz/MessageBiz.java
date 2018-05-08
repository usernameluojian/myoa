package myoa.biz;

import java.util.List;

import myoa.entity.Employee;
import myoa.entity.Message;

public interface MessageBiz {
public List<Message> findReceiverId(int id);
	
	public List<Message> findIsRead(int id);
	
	public List<Message> findDuplicate(int id);
	
	public void Add(Message entity);
	
	public Message findId(int id);
	
	public Message finddescone();
	
	public List<Message> FindMulti(int ReceiverId,int page,int function);
	
	public int FindMultiCount(int ReceiverId,int function);
	
	public void update(Message entity);
}
