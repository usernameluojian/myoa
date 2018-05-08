package myoa.biz;

import myoa.entity.Messageattachment;

public interface MessageattachmentBiz {
	public void Add(Messageattachment entity);
	
	public Messageattachment findMessgeaid(int id);
}
