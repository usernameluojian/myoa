package myoa.web.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
import myoa.dao.MessageattachmentDao;
import myoa.entity.Document;
import myoa.entity.Employee;
import myoa.entity.Message;
import myoa.entity.MessageReception;
import myoa.entity.Messageattachment;

@Controller
public class MessageInboxController {
	
	@Autowired
	private MessageBiz mb;
	
	@Autowired
	private EmployeeBiz eb;
	
	@Autowired
	private MessageattachmentBiz mtb;
	
	@Autowired
	private MessageReceptionBiz mrb;
	
	@RequestMapping("/MessageloadFile")
	public String DownloadFile(HttpServletRequest request, HttpServletResponse response,int id) throws IOException{			
					Messageattachment m = mtb.findMessgeaid(id);
					String Filed = m.getFileurl();
					String fileName = Filed.substring(Filed.lastIndexOf("\\")+1);	
					fileName = new String(fileName.getBytes("iso8859-1"),"UTF-8");
					String realname = fileName.substring(fileName.indexOf("_")+1);
					File file = new File(Filed);
					response.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode(realname, "UTF-8"));
					FileInputStream in = new FileInputStream(Filed);
					OutputStream out = response.getOutputStream();
			         byte buffer[] = new byte[1024];
			         int len = 0;
			         while((len=in.read(buffer))>0){
			             out.write(buffer, 0, len);
			         }
			         in.close();
			         out.close();
					return "redirect:messageInbox";
		        
	}
	
	@RequestMapping(value="messageInbox",method=RequestMethod.GET)
	public String messageInbox(HttpSession session, Map<String,Object> model,
			@RequestParam(name="page", required=false, defaultValue="1") int page){
		Employee e = (Employee) session.getAttribute("user");
		int count = mb.FindMultiCount(e.getId(),1);
		model.put("ListMessage",mb.FindMulti(e.getId(), page,1));
		model.put("Listcount", count);
		model.put("pagecount",count%6==0?(count/6):(count/6)+1);
		model.put("page",page);
		return "messageInbox";
	}
	
	@RequestMapping(value="messageInboxdelete",method=RequestMethod.GET)
	public String messageInboxdelete(int id){
		MessageReception mr = mrb.findOne(id);
		mr.setStatus(1);
		mrb.update(mr);
		return "redirect:messageInbox?typefunction=1";
	}
	
	
	
	@RequestMapping(value="messageReply",method=RequestMethod.GET)
	public String message(Map<String,Object> model,int id) {
		model.put("ReplyEmployee", eb.findid(id));
		return "messagesave";
	}
}
