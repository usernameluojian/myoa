package myoa.web.ajax;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import myoa.biz.EmployeeBiz;
import myoa.biz.EmployeeRoleBiz;
import myoa.biz.FunctionBiz;
import myoa.biz.RoleBiz;
import myoa.dao.RoleFunctionDao;
import myoa.entity.Employee;
import myoa.entity.Role;
import myoa.entity.RoleFunction;

@RestController
public class RoleAjax {
	@Autowired
	private RoleBiz rb;
	
	@Autowired
	private RoleFunctionDao rfd;
	
	@Autowired
	private FunctionBiz fb;
	
	@Autowired
	private EmployeeRoleBiz erb;
	
	@RequestMapping(value="Roleid",method=RequestMethod.GET)
	public Role messagesendingbox(int id){
		return rb.findOne(id);
	}
	
	@RequestMapping(value="Roledeleteoradd",method=RequestMethod.GET)
	public void Roleupdate(HttpSession session,int functionid,int roleid,int type){
		if(type==1) {
			RoleFunction rf = new RoleFunction();
			rf.setFunctionid(functionid);
			rf.setRoleid(roleid);
			rfd.add(rf);
		}else {
			rfd.delete(rfd.findFunctionIdANDroleid(functionid, roleid));
		}
		Employee e = (Employee) session.getAttribute("user");
		session.setAttribute("functionRoleId", fb.FunctionRoleId(erb.findeid(e.getId()).getRoleid()));
	}
}
