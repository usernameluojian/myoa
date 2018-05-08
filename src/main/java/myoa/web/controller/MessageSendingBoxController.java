package myoa.web.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import myoa.biz.EmployeeBiz;
import myoa.biz.MessageBiz;
import myoa.biz.MessageReceptionBiz;
import myoa.biz.MessageattachmentBiz;
import myoa.entity.Employee;
import myoa.entity.Message;
import myoa.entity.MessageReception;

@Controller
public class MessageSendingBoxController {

	@Autowired
	private MessageBiz mb;
	
	@Autowired
	private EmployeeBiz eb;
	
	@Autowired
	private MessageattachmentBiz mtb;
	
	@Autowired
	private MessageReceptionBiz mrb;
	
	@RequestMapping(value="messagesendingbox",method=RequestMethod.GET)
	public String messagesendingbox(HttpSession session, Map<String,Object> model,
			@RequestParam(name="page", required=false, defaultValue="1") int page){
		Employee e = (Employee) session.getAttribute("user");
		int count = mb.FindMultiCount(e.getId(),2);
		model.put("ListMessage",mb.FindMulti(e.getId(), page,2));
		model.put("Listcount", count);
		model.put("pagecount",count%6==0?(count/6):(count/6)+1);
		model.put("page",page);
		return "messagesendingbox";
	}
	
	@RequestMapping(value="messagesendingboxdelete",method=RequestMethod.GET)
	public String messagesendingboxdelete(int id){
		Message m = mb.findId(id);
		m.setStatus(1);
		mb.update(m);
		return "redirect:messagesendingbox";
	}

}
