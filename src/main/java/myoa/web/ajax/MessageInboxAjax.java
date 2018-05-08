package myoa.web.ajax;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import myoa.biz.MessageBiz;
import myoa.biz.MessageReceptionBiz;
import myoa.entity.Message;
import myoa.entity.MessageReception;

@RestController
public class MessageInboxAjax {
	@Autowired
	private MessageBiz mb;
	
	@Autowired
	private MessageReceptionBiz mr;
	
	@RequestMapping("/ajaxMessageOne")
	public Message FindMessageOne(Map<String,Object> model,int id,int rid){
		Message message = mb.findId(id);
		MessageReception messagereception = mr.findOne(rid);
		messagereception.setIsread(false);
		mr.update(messagereception);
		return message;			
	}
}
