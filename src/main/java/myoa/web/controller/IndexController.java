package myoa.web.controller;

import java.util.Map;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import myoa.biz.ActivityBiz;
import myoa.biz.AnnouncementBiz;
import myoa.biz.MessageBiz;
import myoa.entity.Employee;

@Controller
public class IndexController {
	
	@Autowired
	private MessageBiz mb;
	
	@Autowired
	private ActivityBiz ab;
	
	@Autowired
	private AnnouncementBiz annb;
	
	@RequestMapping(value="index",method=RequestMethod.GET)
	public String index(Map<String,Object> model,HttpSession session,int id,int did){
		Employee user = (Employee) session.getAttribute("user");
		model.put("fd", mb.findDuplicate(id));//获取个人邮箱信息其中为重复的邮件
		model.put("fi", mb.findIsRead(id));	//获取个人邮箱信息其中为未读的邮件
		model.put("fr", mb.findReceiverId(id));//获取全部个人邮箱信息
		model.put("ActivitygetAll", ab.findAll());//全部会议
		model.put("ActivitygetTime", ab.findTime());//今日会议
		model.put("Activitygetcid", ab.findActorId(id));//个人会议
		model.put("AnngetAll",annb.findAll());//全部公告
		model.put("Anngetdid", annb.findDepartmentId(did));//部门公告
		return "index";
	}
}
