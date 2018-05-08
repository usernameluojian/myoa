package myoa.biz.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import myoa.biz.MessageattachmentBiz;
import myoa.dao.MessageattachmentDao;
import myoa.entity.Messageattachment;

@Service
public class MessageattachmentBizImpl implements MessageattachmentBiz{

	@Autowired
	private MessageattachmentDao mb;
	
	@Override
	public void Add(Messageattachment entity) {
		// TODO Auto-generated method stub
		mb.Add(entity);
	}

	@Override
	public Messageattachment findMessgeaid(int id) {
		// TODO Auto-generated method stub
		return mb.findMessgeaid(id);
	}

}
