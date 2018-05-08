package myoa.web.ajax;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import myoa.biz.MessageBiz;
import myoa.entity.Message;

@RestController
public class MessageSendingBoxAjax {
	@Autowired
	private MessageBiz mb;
	
	@RequestMapping(value="MessageSendingBoxOne",method=RequestMethod.GET)
	public Message messagesendingbox(int id){
		return mb.findId(id);
	}
}
