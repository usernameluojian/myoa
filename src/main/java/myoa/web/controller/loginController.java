package myoa.web.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import myoa.biz.EmployeeBiz;
import myoa.biz.EmployeeRoleBiz;
import myoa.biz.FunctionBiz;
import myoa.entity.Employee;

@Controller
public class loginController {
	
	@Autowired
	private EmployeeBiz eb;
	
	@Autowired
	private FunctionBiz fb;
	
	@Autowired
	private EmployeeRoleBiz erb;
	
	@RequestMapping(value="login",method=RequestMethod.GET)
	public String login(){
		return "login";
	}
	
	@RequestMapping(value="submit",method=RequestMethod.POST)
	public String submit(String username,String password,HttpSession session){
		Employee e = eb.login(username, password);
		if(e!=null) {
			session.setAttribute("user", e);
			session.setAttribute("function", fb.FunctionisNULL());
			session.setAttribute("IsNotfunction", fb.FunctionisNotNULL());
			session.setAttribute("functionRoleId", fb.FunctionRoleId(erb.findeid(e.getId()).getRoleid()));
			return "redirect:index";
		}else {
			return "login";
		}
	}
}
