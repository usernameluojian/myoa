package myoa.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import myoa.biz.MessageBiz;
import myoa.dao.MessageDao;
import myoa.dao.MessageReceptionDao;
import myoa.dao.MessageattachmentDao;
import myoa.entity.Employee;
import myoa.entity.Message;
import myoa.entity.MessageReception;

@Service
public class MessageBizImpl implements MessageBiz {

	@Autowired
	private MessageDao md;
	
	@Autowired
	private MessageattachmentDao mtcb;
	
	@Autowired
	private MessageReceptionDao mrtp;
	
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

	@Override
	public void Add(Message entity) {
		// TODO Auto-generated method stub
		md.Add(entity);
	}

	@Override
	public Message findId(int id) {
		// TODO Auto-generated method stub
		return md.findId(id);
	}

	@Override
	public Message finddescone() {
		// TODO Auto-generated method stub
		return md.finddescone();
	}
	
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-beans.xml");
		MessageBiz d = ctx.getBean(MessageBiz.class);
		
	}

	@Override
	public List<Message> FindMulti(int ReceiverId,int page,int function) {
		List<Message> list = md.FindMulti(ReceiverId,page,function);
		for (Message message : list) {
			message.setMstch(mtcb.findMessgeaid(message.getId()));
			MessageReception mrp = mrtp.findMessageReceptionOne(message.getId(), ReceiverId);
			if(mrp!=null) {
				message.setMessagereceptionIRead(mrp.getIsread());
				message.setMessagereceptionid(mrp.getId());
			}
		}
		return list;
	}

	@Override
	public int FindMultiCount(int ReceiverId,int function) {
		// TODO Auto-generated method stub
		return md.FindMultiCount(ReceiverId,function);
	}

	@Override
	public void update(Message entity) {
		// TODO Auto-generated method stub
		md.update(entity);
	}

}
