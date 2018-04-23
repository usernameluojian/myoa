package myoa.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import myoa.biz.MessageBiz;
import myoa.dao.MessageDao;
import myoa.entity.Message;

@Service
public class MessageBizImpl implements MessageBiz {

	@Autowired
	private MessageDao md;
	
	@Override
	public List<Message> findReceiverId(int id) {
		// TODO Auto-generated method stub
		return md.findReceiverId(id);
	}

	@Override
	public List<Message> findIsRead(int id) {
		// TODO Auto-generated method stub
		return md.findIsRead(id);
	}

	@Override
	public List<Message> findDuplicate(int id) {
		// TODO Auto-generated method stub
		return md.findDuplicate(id);
	}

}
