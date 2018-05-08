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
import myoa.entity.Employee;
import myoa.entity.Message;

@Controller
public class MessageDraftsController {
	@Autowired
	private MessageBiz mb;
	
	@Autowired
	private EmployeeBiz eb;
	
	@RequestMapping(value="messagedrafts",method=RequestMethod.GET)
	public String messagedrafts(HttpSession session, Map<String,Object> model,
			@RequestParam(name="page", required=false, defaultValue="1") int page){
		Employee e = (Employee) session.getAttribute("user");
		int count = mb.FindMultiCount(e.getId(),3);
		model.put("ListMessage",mb.FindMulti(e.getId(), page,3));
		model.put("Listcount", count);
		model.put("pagecount",count%6==0?(count/6):(count/6)+1);
		model.put("page",page);
		return "messagedrafts";
	}
	
	@RequestMapping(value="messagedraftsfasong",method=RequestMethod.GET)
	public String messagedraftsfasong(int id) {
		Message message = mb.findId(id);
		message.setIssent(true);
		mb.update(message);
		return "redirect:messagedrafts";
	}
}
