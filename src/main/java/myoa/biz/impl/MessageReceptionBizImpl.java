package myoa.biz.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import myoa.biz.MessageReceptionBiz;
import myoa.dao.MessageReceptionDao;
import myoa.entity.MessageReception;

@Service
public class MessageReceptionBizImpl implements MessageReceptionBiz {

	@Autowired
	private MessageReceptionDao mrb;
	
	@Override
	public void Add(MessageReception entity) {
		// TODO Auto-generated method stub
		mrb.Add(entity);
	}

	@Override
	public void update(MessageReception entity) {
		// TODO Auto-generated method stub
		mrb.update(entity);
	}

	@Override
	public MessageReception findOne(int id) {
		// TODO Auto-generated method stub
		return mrb.findOne(id);
	}

}
