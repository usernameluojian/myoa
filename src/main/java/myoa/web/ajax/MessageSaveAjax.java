package myoa.web.ajax;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import myoa.biz.DepartmentBiz;
import myoa.entity.Department;
import myoa.entity.Document;

@RestController
public class MessageSaveAjax {
	
	@Autowired
	private DepartmentBiz db;
	
	@RequestMapping("/Departmentztree")
	public List<Department> folders(){
		return db.findztree();
	}
}
