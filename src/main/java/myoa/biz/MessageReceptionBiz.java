package myoa.biz;

import myoa.entity.MessageReception;

public interface MessageReceptionBiz {
	public void Add(MessageReception entity);
	
	public void update(MessageReception entity);
	
	public MessageReception findOne(int id);
}
