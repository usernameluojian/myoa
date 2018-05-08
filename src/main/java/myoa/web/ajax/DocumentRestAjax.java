package myoa.web.ajax;

import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import myoa.biz.DocumentBiz;
import myoa.entity.Document;

@RestController
public class DocumentRestAjax {

	@Autowired
	private DocumentBiz documentBiz;
	
	@RequestMapping("/folders")
	public List<Document> folders(){
		return documentBiz.getAllFoldersInLevel();
	}
	
	@RequestMapping("/documents")
	public List<Document> folders(int folderId){
		return documentBiz.getDocumentsByFolder(folderId);
	}
	
	@RequestMapping("/selectlikename")
	public List<Document> selectlikename(int folderId,String name){
		return documentBiz.findlikename(folderId, name);
	}
	
	@RequestMapping("/openFile")
	public void openFile(String Filed){
		
		Filed = Filed.replace("\\","/");
		System.out.println(Filed);
		File file = new File(Filed);
		try {
			Desktop.getDesktop().open(file);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
