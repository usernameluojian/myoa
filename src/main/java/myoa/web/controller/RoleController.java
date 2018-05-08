package myoa.web.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import myoa.biz.RoleBiz;
import myoa.entity.Role;

@Controller
public class RoleController {
	
	@Autowired
	private RoleBiz rb;
	
	@RequestMapping(value="Role",method=RequestMethod.GET)
	public String Rolee(Map<String,Object> model){
		model.put("listRole", rb.findAll());
		return "Role";
	}
	
	@RequestMapping(value="Roleupdate",method=RequestMethod.GET)
	public String Roleupdate(Role role){
		rb.update(role);
		return "redirect:Role";
	}
}
